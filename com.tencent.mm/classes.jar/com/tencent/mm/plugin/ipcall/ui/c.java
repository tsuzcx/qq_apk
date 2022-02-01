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
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.aj.p;
import com.tencent.mm.plugin.ipcall.model.h.b;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bs;
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
  static HashMap<String, com.tencent.mm.plugin.ipcall.model.h.c> tLD = null;
  HashMap<String, Integer> fAf;
  private String iJd;
  az iWe;
  private Context mContext;
  boolean nwB;
  private d tMD;
  private HashMap<Long, com.tencent.mm.plugin.ipcall.model.h.c> tME;
  private HashSet<String> tMF;
  private boolean tMG;
  private View.OnClickListener tMH;
  
  public c(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(25613);
    this.tME = new HashMap();
    this.fAf = new HashMap();
    this.tMF = new HashSet();
    this.tMG = false;
    this.nwB = false;
    this.tMH = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25611);
        if ((paramAnonymousView.getTag() instanceof Integer))
        {
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          Object localObject = c.this.Hj(i);
          paramAnonymousView = new Intent(c.a(c.this), IPCallUserProfileUI.class);
          paramAnonymousView.putExtra("IPCallProfileUI_contactid", ((com.tencent.mm.plugin.ipcall.model.h.c)localObject).field_contactId);
          paramAnonymousView.putExtra("IPCallProfileUI_systemUsername", ((com.tencent.mm.plugin.ipcall.model.h.c)localObject).field_systemAddressBookUsername);
          paramAnonymousView.putExtra("IPCallProfileUI_wechatUsername", ((com.tencent.mm.plugin.ipcall.model.h.c)localObject).field_wechatUsername);
          localObject = c.b(c.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.aeD(), "com/tencent/mm/plugin/ipcall/ui/IPCallAddressAdapter$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject).startActivity((Intent)paramAnonymousView.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressAdapter$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(25611);
      }
    };
    this.iWe = new az();
    wy(true);
    this.mContext = paramContext;
    this.tMD = new d(paramContext);
    p.aBh().a(this);
    AppMethodBeat.o(25613);
  }
  
  private static String a(com.tencent.mm.plugin.ipcall.model.h.c paramc, String paramString)
  {
    AppMethodBeat.i(25622);
    if ((paramc != null) && (paramc.tLE != null))
    {
      paramc = paramc.tLE.iterator();
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
  
  private static String aiY(String paramString)
  {
    AppMethodBeat.i(25623);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(25623);
      return "";
    }
    if (paramString.startsWith(b.fAe))
    {
      AppMethodBeat.o(25623);
      return "#";
    }
    paramString = paramString.toUpperCase().substring(0, 1);
    AppMethodBeat.o(25623);
    return paramString;
  }
  
  private void cVj()
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
        localObject2 = aiY(((com.tencent.mm.plugin.ipcall.model.h.c)localObject2).field_sortKey);
        if (i == 0) {
          this.fAf.put(localObject2, Integer.valueOf(i));
        }
        for (;;)
        {
          i += 1;
          localCursor.moveToNext();
          localObject1 = localObject2;
          break;
          if ((localObject1 != null) && (!((String)localObject2).equals(localObject1))) {
            this.fAf.put(localObject2, Integer.valueOf(i));
          }
        }
        AppMethodBeat.o(25628);
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.IPCallAddressAdapter", "initSectionPosMap error: %s", new Object[] { localException.getMessage() });
      }
    }
    else
    {
      return;
    }
    label153:
    AppMethodBeat.o(25628);
  }
  
  public final void Af(String paramString)
  {
    AppMethodBeat.i(25626);
    if (this.tMF.contains(paramString)) {
      ap.f(new Runnable()
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
  
  public final void FZ(String paramString)
  {
    AppMethodBeat.i(25617);
    this.iJd = paramString;
    if (bs.isNullOrNil(this.iJd)) {}
    for (this.tMG = false;; this.tMG = true)
    {
      this.HmX.clear();
      Xb();
      notifyDataSetChanged();
      AppMethodBeat.o(25617);
      return;
    }
  }
  
  public final com.tencent.mm.plugin.ipcall.model.h.c Hj(int paramInt)
  {
    AppMethodBeat.i(25616);
    com.tencent.mm.plugin.ipcall.model.h.c localc = (com.tencent.mm.plugin.ipcall.model.h.c)super.getItem(paramInt);
    AppMethodBeat.o(25616);
    return localc;
  }
  
  public final void Xb()
  {
    AppMethodBeat.i(25618);
    Cursor localCursor;
    if (!this.tMG) {
      localCursor = i.cUB().cVc();
    }
    for (;;)
    {
      if (localCursor != null) {
        localCursor.moveToFirst();
      }
      setCursor(localCursor);
      cVj();
      AppMethodBeat.o(25618);
      return;
      this.nwB = true;
      localCursor = i.cUB().aiO(this.iJd);
      this.nwB = false;
    }
  }
  
  public final void Xc()
  {
    AppMethodBeat.i(25620);
    super.cVi();
    Xb();
    AppMethodBeat.o(25620);
  }
  
  public final int cVh()
  {
    AppMethodBeat.i(25615);
    int i = super.getCount();
    AppMethodBeat.o(25615);
    return i;
  }
  
  public final void cVi()
  {
    AppMethodBeat.i(25619);
    super.cVi();
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
      paramView.tMT = localView.findViewById(2131301153);
      paramView.tMU = localView.findViewById(2131299159);
      paramView.fxQ = ((ImageView)localView.findViewById(2131297008));
      paramView.iIU = ((TextView)localView.findViewById(2131302867));
      paramView.tML = ((TextView)localView.findViewById(2131303238));
      paramView.tMM = ((LinearLayout)localView.findViewById(2131303812));
      paramView.tMN = ((TextView)localView.findViewById(2131303815));
      paramView.tMO = ((TextView)localView.findViewById(2131303816));
      paramView.tMP = ((TextView)localView.findViewById(2131296493));
      paramView.tMQ = ((TextView)localView.findViewById(2131296482));
      paramView.tMR = ((ImageView)localView.findViewById(2131296483));
      paramView.tMS = localView.findViewById(2131301156);
      paramView.tMS.setClickable(true);
      paramView.tMV = ((ImageView)localView.findViewById(2131299154));
      localView.setTag(paramView);
    }
    paramViewGroup = (b)localView.getTag();
    paramViewGroup.tMS.setClickable(true);
    paramViewGroup.tMS.setTag(Integer.valueOf(paramInt));
    paramViewGroup.tMV.setVisibility(8);
    int j;
    int i;
    if (GF(paramInt))
    {
      paramViewGroup.iIU.setVisibility(8);
      paramViewGroup.tML.setVisibility(8);
      paramViewGroup.tMM.setVisibility(8);
      paramViewGroup.fxQ.setVisibility(8);
      paramViewGroup.fxQ.setTag(null);
      paramViewGroup.tMQ.setVisibility(8);
      paramViewGroup.tMP.setVisibility(8);
      paramViewGroup.tMR.setVisibility(8);
      j = 1;
      i = j;
      if (Hj(paramInt + 1) != null)
      {
        i = j;
        if (Hj(paramInt) != null)
        {
          i = j;
          if (!aiY(Hj(paramInt + 1).field_sortKey).equals(aiY(Hj(paramInt).field_sortKey))) {
            i = 0;
          }
        }
      }
      if ((paramInt + 1 != getCount()) && (i != 0)) {
        break label1583;
      }
      paramViewGroup.tMU.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(25621);
      return localView;
      com.tencent.mm.plugin.ipcall.model.h.c localc = Hj(paramInt);
      if (localc != null)
      {
        if (bs.isNullOrNil(localc.field_systemAddressBookUsername)) {
          break label1430;
        }
        paramViewGroup.iIU.setVisibility(0);
        if (!this.tMG) {
          break label919;
        }
        paramViewGroup.tML.setVisibility(0);
        paramView = (FrameLayout.LayoutParams)paramViewGroup.tMT.getLayoutParams();
        paramView.height = ((int)paramViewGroup.tML.getContext().getResources().getDimension(2131165717));
        paramViewGroup.tMT.setLayoutParams(paramView);
        paramView = (RelativeLayout.LayoutParams)paramViewGroup.fxQ.getLayoutParams();
        paramView.height = ((int)paramViewGroup.fxQ.getContext().getResources().getDimension(2131165713));
        paramView.width = ((int)paramViewGroup.fxQ.getContext().getResources().getDimension(2131165713));
        paramViewGroup.fxQ.setLayoutParams(paramView);
        label602:
        if ((!this.tMG) || (localc.tLE != null) || (tLD == null) || (!tLD.containsKey(localc.field_contactId))) {
          break label1032;
        }
        localc.tLE = ((com.tencent.mm.plugin.ipcall.model.h.c)tLD.get(localc.field_contactId)).tLE;
        label659:
        if ((bs.isNullOrNil(this.iJd)) || ((!bs.E(this.iJd.charAt(0))) && (!this.iJd.startsWith("+")))) {
          break label1083;
        }
        paramView = com.tencent.mm.plugin.fts.a.f.b(a(localc, this.iJd), az.aLb(this.iJd));
        paramViewGroup.tML.setText(paramView);
        paramView = com.tencent.mm.plugin.fts.a.f.b(localc.field_systemAddressBookUsername, this.iJd);
        paramViewGroup.iIU.setText(paramView);
        label745:
        paramView = paramViewGroup.fxQ;
        if (paramView != null)
        {
          paramView.setVisibility(0);
          paramView.setTag(null);
          paramView.setImageResource(2131232743);
          if (localc != null)
          {
            if ((bs.isNullOrNil(localc.field_contactId)) || (bs.isNullOrNil(localc.field_wechatUsername))) {
              break label1451;
            }
            this.tMD.a(localc.field_contactId, localc.field_wechatUsername, paramView);
            label816:
            if (!bs.isNullOrNil(localc.field_wechatUsername)) {
              this.tMF.add(localc.field_wechatUsername);
            }
          }
        }
        paramViewGroup.tMM.setVisibility(8);
        paramView = aiY(localc.field_sortKey);
        if (paramInt != 0) {
          break label1505;
        }
        paramViewGroup.tMP.setVisibility(0);
        paramViewGroup.tMP.setText(paramView);
        paramViewGroup.tMQ.setVisibility(8);
      }
      for (;;)
      {
        paramViewGroup.tMS.setVisibility(8);
        paramViewGroup.tMR.setVisibility(8);
        paramViewGroup.tMR.setOnClickListener(this.tMH);
        break;
        label919:
        paramViewGroup.tML.setVisibility(8);
        paramView = (FrameLayout.LayoutParams)paramViewGroup.tMT.getLayoutParams();
        paramView.height = ((int)paramViewGroup.tML.getContext().getResources().getDimension(2131165716));
        paramViewGroup.tMT.setLayoutParams(paramView);
        paramView = (RelativeLayout.LayoutParams)paramViewGroup.fxQ.getLayoutParams();
        paramView.height = ((int)paramViewGroup.fxQ.getContext().getResources().getDimension(2131165714));
        paramView.width = ((int)paramViewGroup.fxQ.getContext().getResources().getDimension(2131165714));
        paramViewGroup.fxQ.setLayoutParams(paramView);
        break label602;
        label1032:
        if ((!this.tMG) || (localc.tLE != null) || ((tLD != null) && (!tLD.containsKey(localc.field_contactId)))) {
          break label659;
        }
        localc.tLE = b.aiL(localc.field_contactId);
        break label659;
        label1083:
        if ((!bs.isNullOrNil(this.iJd)) && (!bs.E(this.iJd.charAt(0))))
        {
          String str1 = localc.field_systemAddressBookUsername;
          Object localObject = localc.field_systemAddressBookUsername;
          paramView = this.iJd;
          if ((bs.isNullOrNil(paramView)) || (bs.isNullOrNil((String)localObject))) {
            paramView = "";
          }
          label1402:
          for (;;)
          {
            paramView = com.tencent.mm.plugin.fts.a.f.b(str1, paramView);
            paramViewGroup.iIU.setText(paramView);
            paramViewGroup.tML.setText(a(localc, this.iJd));
            break;
            if ((!bs.aLj(paramView)) && (bs.aLk(paramView)))
            {
              ArrayList localArrayList = new ArrayList();
              i = 0;
              String str2;
              while (i < ((String)localObject).length())
              {
                str2 = ((String)localObject).substring(i, i + 1);
                localArrayList.add(new a(com.tencent.mm.platformtools.f.Fv(str2), str2));
                i += 1;
              }
              i = 2;
              while (i <= ((String)localObject).length())
              {
                j = 0;
                while (j <= ((String)localObject).length() - i)
                {
                  str2 = ((String)localObject).substring(j, j + i);
                  localArrayList.add(new a(com.tencent.mm.platformtools.f.Fv(str2), str2));
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
                if (((a)localObject).tMJ.contains(paramView))
                {
                  paramView = ((a)localObject).tMK;
                  break;
                }
                i += 1;
              }
            }
          }
        }
        if (!bs.isNullOrNil(this.iJd)) {
          break label745;
        }
        paramViewGroup.iIU.setText(localc.field_systemAddressBookUsername);
        break label745;
        label1430:
        paramViewGroup.iIU.setVisibility(8);
        paramViewGroup.tML.setVisibility(8);
        break label745;
        label1451:
        if (!bs.isNullOrNil(localc.field_contactId))
        {
          this.tMD.c(localc.field_contactId, paramView);
          break label816;
        }
        if (bs.isNullOrNil(localc.field_wechatUsername)) {
          break label816;
        }
        this.tMD.e(localc.field_wechatUsername, paramView);
        break label816;
        label1505:
        if (!aiY(Hj(paramInt - 1).field_sortKey).equals(paramView))
        {
          paramViewGroup.tMP.setVisibility(0);
          paramViewGroup.tMP.setText(paramView);
          paramViewGroup.tMQ.setVisibility(8);
        }
        else
        {
          paramViewGroup.tMP.setVisibility(8);
          paramViewGroup.tMP.setText("");
          paramViewGroup.tMQ.setVisibility(8);
        }
      }
      label1583:
      paramViewGroup.tMU.setVisibility(0);
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
    this.tME.clear();
    super.notifyDataSetChanged();
    AppMethodBeat.o(25627);
  }
  
  final class a
  {
    String tMJ;
    String tMK;
    
    public a(String paramString1, String paramString2)
    {
      this.tMK = paramString2;
      this.tMJ = paramString1;
    }
  }
  
  final class b
  {
    ImageView fxQ;
    TextView iIU;
    TextView tML;
    LinearLayout tMM;
    TextView tMN;
    TextView tMO;
    TextView tMP;
    TextView tMQ;
    ImageView tMR;
    View tMS;
    View tMT;
    View tMU;
    ImageView tMV;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.c
 * JD-Core Version:    0.7.0.1
 */