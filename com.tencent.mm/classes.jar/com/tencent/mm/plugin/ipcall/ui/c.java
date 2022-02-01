package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.p;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
  extends r<com.tencent.mm.plugin.ipcall.model.h.c>
  implements e.a
{
  static HashMap<String, com.tencent.mm.plugin.ipcall.model.h.c> uOq = null;
  HashMap<String, Integer> fTv;
  private String jcm;
  ba jpn;
  private Context mContext;
  boolean nXZ;
  private d uPq;
  private HashMap<Long, com.tencent.mm.plugin.ipcall.model.h.c> uPr;
  private HashSet<String> uPs;
  private boolean uPt;
  private View.OnClickListener uPu;
  
  public c(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(25613);
    this.uPr = new HashMap();
    this.fTv = new HashMap();
    this.uPs = new HashSet();
    this.uPt = false;
    this.nXZ = false;
    this.uPu = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25611);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallAddressAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if ((paramAnonymousView.getTag() instanceof Integer))
        {
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          localObject = c.this.IF(i);
          paramAnonymousView = new Intent(c.a(c.this), IPCallUserProfileUI.class);
          paramAnonymousView.putExtra("IPCallProfileUI_contactid", ((com.tencent.mm.plugin.ipcall.model.h.c)localObject).field_contactId);
          paramAnonymousView.putExtra("IPCallProfileUI_systemUsername", ((com.tencent.mm.plugin.ipcall.model.h.c)localObject).field_systemAddressBookUsername);
          paramAnonymousView.putExtra("IPCallProfileUI_wechatUsername", ((com.tencent.mm.plugin.ipcall.model.h.c)localObject).field_wechatUsername);
          localObject = c.b(c.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahp(), "com/tencent/mm/plugin/ipcall/ui/IPCallAddressAdapter$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject).startActivity((Intent)paramAnonymousView.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressAdapter$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(25611);
      }
    };
    this.jpn = new ba();
    xk(true);
    this.mContext = paramContext;
    this.uPq = new d(paramContext);
    p.aEk().a(this);
    AppMethodBeat.o(25613);
  }
  
  private static String a(com.tencent.mm.plugin.ipcall.model.h.c paramc, String paramString)
  {
    AppMethodBeat.i(25622);
    if ((paramc != null) && (paramc.uOr != null))
    {
      paramc = paramc.uOr.iterator();
      while (paramc.hasNext())
      {
        String str = (String)paramc.next();
        if (str.contains(paramString))
        {
          AppMethodBeat.o(25622);
          return str;
        }
      }
    }
    AppMethodBeat.o(25622);
    return null;
  }
  
  private static String anL(String paramString)
  {
    AppMethodBeat.i(25623);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(25623);
      return "";
    }
    if (paramString.startsWith(com.tencent.mm.plugin.ipcall.model.h.b.fTu))
    {
      AppMethodBeat.o(25623);
      return "#";
    }
    paramString = paramString.toUpperCase().substring(0, 1);
    AppMethodBeat.o(25623);
    return paramString;
  }
  
  private void deu()
  {
    AppMethodBeat.i(25628);
    if (getCursor() != null)
    {
      Cursor localCursor = getCursor();
      Object localObject1 = null;
      try
      {
        if (!localCursor.moveToFirst()) {
          break label153;
        }
        int i = 0;
        if (localCursor.isAfterLast()) {
          break label153;
        }
        Object localObject2 = new com.tencent.mm.plugin.ipcall.model.h.c();
        ((com.tencent.mm.plugin.ipcall.model.h.c)localObject2).convertFrom(localCursor);
        localObject2 = anL(((com.tencent.mm.plugin.ipcall.model.h.c)localObject2).field_sortKey);
        if (i == 0) {
          this.fTv.put(localObject2, Integer.valueOf(i));
        }
        for (;;)
        {
          i += 1;
          localCursor.moveToNext();
          localObject1 = localObject2;
          break;
          if ((localObject1 != null) && (!((String)localObject2).equals(localObject1))) {
            this.fTv.put(localObject2, Integer.valueOf(i));
          }
        }
        AppMethodBeat.o(25628);
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.IPCallAddressAdapter", "initSectionPosMap error: %s", new Object[] { localException.getMessage() });
      }
    }
    else
    {
      return;
    }
    label153:
    AppMethodBeat.o(25628);
  }
  
  public final void De(String paramString)
  {
    AppMethodBeat.i(25626);
    if (this.uPs.contains(paramString)) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25612);
          c.this.notifyDataSetChanged();
          AppMethodBeat.o(25612);
        }
      });
    }
    AppMethodBeat.o(25626);
  }
  
  public final com.tencent.mm.plugin.ipcall.model.h.c IF(int paramInt)
  {
    AppMethodBeat.i(25616);
    com.tencent.mm.plugin.ipcall.model.h.c localc = (com.tencent.mm.plugin.ipcall.model.h.c)super.getItem(paramInt);
    AppMethodBeat.o(25616);
    return localc;
  }
  
  public final void Jo(String paramString)
  {
    AppMethodBeat.i(25617);
    this.jcm = paramString;
    if (bt.isNullOrNil(this.jcm)) {}
    for (this.uPt = false;; this.uPt = true)
    {
      this.JaE.clear();
      Zu();
      notifyDataSetChanged();
      AppMethodBeat.o(25617);
      return;
    }
  }
  
  public final void Zu()
  {
    AppMethodBeat.i(25618);
    Cursor localCursor;
    if (!this.uPt) {
      localCursor = i.ddM().den();
    }
    for (;;)
    {
      if (localCursor != null) {
        localCursor.moveToFirst();
      }
      setCursor(localCursor);
      deu();
      AppMethodBeat.o(25618);
      return;
      this.nXZ = true;
      localCursor = i.ddM().anB(this.jcm);
      this.nXZ = false;
    }
  }
  
  public final void Zv()
  {
    AppMethodBeat.i(25620);
    super.det();
    Zu();
    AppMethodBeat.o(25620);
  }
  
  public final int des()
  {
    AppMethodBeat.i(25615);
    int i = super.getCount();
    AppMethodBeat.o(25615);
    return i;
  }
  
  public final void det()
  {
    AppMethodBeat.i(25619);
    super.det();
    AppMethodBeat.o(25619);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(25614);
    int i = super.getCount();
    AppMethodBeat.o(25614);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(25624);
    paramInt = super.getItemViewType(paramInt);
    AppMethodBeat.o(25624);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(25621);
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.context).inflate(2131494512, paramViewGroup, false);
      paramView = new b((byte)0);
      paramView.uPG = localView.findViewById(2131301153);
      paramView.uPH = localView.findViewById(2131299159);
      paramView.fRd = ((ImageView)localView.findViewById(2131297008));
      paramView.jcd = ((TextView)localView.findViewById(2131302867));
      paramView.uPy = ((TextView)localView.findViewById(2131303238));
      paramView.uPz = ((LinearLayout)localView.findViewById(2131303812));
      paramView.uPA = ((TextView)localView.findViewById(2131303815));
      paramView.uPB = ((TextView)localView.findViewById(2131303816));
      paramView.uPC = ((TextView)localView.findViewById(2131296493));
      paramView.uPD = ((TextView)localView.findViewById(2131296482));
      paramView.uPE = ((ImageView)localView.findViewById(2131296483));
      paramView.uPF = localView.findViewById(2131301156);
      paramView.uPF.setClickable(true);
      paramView.uPI = ((ImageView)localView.findViewById(2131299154));
      localView.setTag(paramView);
    }
    paramViewGroup = (b)localView.getTag();
    paramViewGroup.uPF.setClickable(true);
    paramViewGroup.uPF.setTag(Integer.valueOf(paramInt));
    paramViewGroup.uPI.setVisibility(8);
    int j;
    int i;
    if (HY(paramInt))
    {
      paramViewGroup.jcd.setVisibility(8);
      paramViewGroup.uPy.setVisibility(8);
      paramViewGroup.uPz.setVisibility(8);
      paramViewGroup.fRd.setVisibility(8);
      paramViewGroup.fRd.setTag(null);
      paramViewGroup.uPD.setVisibility(8);
      paramViewGroup.uPC.setVisibility(8);
      paramViewGroup.uPE.setVisibility(8);
      j = 1;
      i = j;
      if (IF(paramInt + 1) != null)
      {
        i = j;
        if (IF(paramInt) != null)
        {
          i = j;
          if (!anL(IF(paramInt + 1).field_sortKey).equals(anL(IF(paramInt).field_sortKey))) {
            i = 0;
          }
        }
      }
      if ((paramInt + 1 != getCount()) && (i != 0)) {
        break label1583;
      }
      paramViewGroup.uPH.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(25621);
      return localView;
      com.tencent.mm.plugin.ipcall.model.h.c localc = IF(paramInt);
      if (localc != null)
      {
        if (bt.isNullOrNil(localc.field_systemAddressBookUsername)) {
          break label1430;
        }
        paramViewGroup.jcd.setVisibility(0);
        if (!this.uPt) {
          break label919;
        }
        paramViewGroup.uPy.setVisibility(0);
        paramView = (FrameLayout.LayoutParams)paramViewGroup.uPG.getLayoutParams();
        paramView.height = ((int)paramViewGroup.uPy.getContext().getResources().getDimension(2131165717));
        paramViewGroup.uPG.setLayoutParams(paramView);
        paramView = (RelativeLayout.LayoutParams)paramViewGroup.fRd.getLayoutParams();
        paramView.height = ((int)paramViewGroup.fRd.getContext().getResources().getDimension(2131165713));
        paramView.width = ((int)paramViewGroup.fRd.getContext().getResources().getDimension(2131165713));
        paramViewGroup.fRd.setLayoutParams(paramView);
        label602:
        if ((!this.uPt) || (localc.uOr != null) || (uOq == null) || (!uOq.containsKey(localc.field_contactId))) {
          break label1032;
        }
        localc.uOr = ((com.tencent.mm.plugin.ipcall.model.h.c)uOq.get(localc.field_contactId)).uOr;
        label659:
        if ((bt.isNullOrNil(this.jcm)) || ((!bt.G(this.jcm.charAt(0))) && (!this.jcm.startsWith("+")))) {
          break label1083;
        }
        paramView = com.tencent.mm.plugin.fts.a.f.b(a(localc, this.jcm), ba.aQH(this.jcm));
        paramViewGroup.uPy.setText(paramView);
        paramView = com.tencent.mm.plugin.fts.a.f.b(localc.field_systemAddressBookUsername, this.jcm);
        paramViewGroup.jcd.setText(paramView);
        label745:
        paramView = paramViewGroup.fRd;
        if (paramView != null)
        {
          paramView.setVisibility(0);
          paramView.setTag(null);
          paramView.setImageResource(2131232743);
          if (localc != null)
          {
            if ((bt.isNullOrNil(localc.field_contactId)) || (bt.isNullOrNil(localc.field_wechatUsername))) {
              break label1451;
            }
            this.uPq.a(localc.field_contactId, localc.field_wechatUsername, paramView);
            label816:
            if (!bt.isNullOrNil(localc.field_wechatUsername)) {
              this.uPs.add(localc.field_wechatUsername);
            }
          }
        }
        paramViewGroup.uPz.setVisibility(8);
        paramView = anL(localc.field_sortKey);
        if (paramInt != 0) {
          break label1505;
        }
        paramViewGroup.uPC.setVisibility(0);
        paramViewGroup.uPC.setText(paramView);
        paramViewGroup.uPD.setVisibility(8);
      }
      for (;;)
      {
        paramViewGroup.uPF.setVisibility(8);
        paramViewGroup.uPE.setVisibility(8);
        paramViewGroup.uPE.setOnClickListener(this.uPu);
        break;
        label919:
        paramViewGroup.uPy.setVisibility(8);
        paramView = (FrameLayout.LayoutParams)paramViewGroup.uPG.getLayoutParams();
        paramView.height = ((int)paramViewGroup.uPy.getContext().getResources().getDimension(2131165716));
        paramViewGroup.uPG.setLayoutParams(paramView);
        paramView = (RelativeLayout.LayoutParams)paramViewGroup.fRd.getLayoutParams();
        paramView.height = ((int)paramViewGroup.fRd.getContext().getResources().getDimension(2131165714));
        paramView.width = ((int)paramViewGroup.fRd.getContext().getResources().getDimension(2131165714));
        paramViewGroup.fRd.setLayoutParams(paramView);
        break label602;
        label1032:
        if ((!this.uPt) || (localc.uOr != null) || ((uOq != null) && (!uOq.containsKey(localc.field_contactId)))) {
          break label659;
        }
        localc.uOr = com.tencent.mm.plugin.ipcall.model.h.b.any(localc.field_contactId);
        break label659;
        label1083:
        if ((!bt.isNullOrNil(this.jcm)) && (!bt.G(this.jcm.charAt(0))))
        {
          String str1 = localc.field_systemAddressBookUsername;
          Object localObject = localc.field_systemAddressBookUsername;
          paramView = this.jcm;
          if ((bt.isNullOrNil(paramView)) || (bt.isNullOrNil((String)localObject))) {
            paramView = "";
          }
          label1402:
          for (;;)
          {
            paramView = com.tencent.mm.plugin.fts.a.f.b(str1, paramView);
            paramViewGroup.jcd.setText(paramView);
            paramViewGroup.uPy.setText(a(localc, this.jcm));
            break;
            if ((!bt.aQP(paramView)) && (bt.aQQ(paramView)))
            {
              ArrayList localArrayList = new ArrayList();
              i = 0;
              String str2;
              while (i < ((String)localObject).length())
              {
                str2 = ((String)localObject).substring(i, i + 1);
                localArrayList.add(new a(com.tencent.mm.platformtools.f.IL(str2), str2));
                i += 1;
              }
              i = 2;
              while (i <= ((String)localObject).length())
              {
                j = 0;
                while (j <= ((String)localObject).length() - i)
                {
                  str2 = ((String)localObject).substring(j, j + i);
                  localArrayList.add(new a(com.tencent.mm.platformtools.f.IL(str2), str2));
                  j += 1;
                }
                i += 1;
              }
              i = 0;
              for (;;)
              {
                if (i >= localArrayList.size()) {
                  break label1402;
                }
                localObject = (a)localArrayList.get(i);
                if (((a)localObject).uPw.contains(paramView))
                {
                  paramView = ((a)localObject).uPx;
                  break;
                }
                i += 1;
              }
            }
          }
        }
        if (!bt.isNullOrNil(this.jcm)) {
          break label745;
        }
        paramViewGroup.jcd.setText(localc.field_systemAddressBookUsername);
        break label745;
        label1430:
        paramViewGroup.jcd.setVisibility(8);
        paramViewGroup.uPy.setVisibility(8);
        break label745;
        label1451:
        if (!bt.isNullOrNil(localc.field_contactId))
        {
          this.uPq.d(localc.field_contactId, paramView);
          break label816;
        }
        if (bt.isNullOrNil(localc.field_wechatUsername)) {
          break label816;
        }
        this.uPq.f(localc.field_wechatUsername, paramView);
        break label816;
        label1505:
        if (!anL(IF(paramInt - 1).field_sortKey).equals(paramView))
        {
          paramViewGroup.uPC.setVisibility(0);
          paramViewGroup.uPC.setText(paramView);
          paramViewGroup.uPD.setVisibility(8);
        }
        else
        {
          paramViewGroup.uPC.setVisibility(8);
          paramViewGroup.uPC.setText("");
          paramViewGroup.uPD.setVisibility(8);
        }
      }
      label1583:
      paramViewGroup.uPH.setVisibility(0);
    }
  }
  
  public final int getViewTypeCount()
  {
    AppMethodBeat.i(25625);
    int i = super.getViewTypeCount();
    AppMethodBeat.o(25625);
    return i;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(25627);
    this.uPr.clear();
    super.notifyDataSetChanged();
    AppMethodBeat.o(25627);
  }
  
  final class a
  {
    String uPw;
    String uPx;
    
    public a(String paramString1, String paramString2)
    {
      this.uPx = paramString2;
      this.uPw = paramString1;
    }
  }
  
  final class b
  {
    ImageView fRd;
    TextView jcd;
    TextView uPA;
    TextView uPB;
    TextView uPC;
    TextView uPD;
    ImageView uPE;
    View uPF;
    View uPG;
    View uPH;
    ImageView uPI;
    TextView uPy;
    LinearLayout uPz;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.c
 * JD-Core Version:    0.7.0.1
 */