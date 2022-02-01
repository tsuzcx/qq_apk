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
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bu;
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
  static HashMap<String, com.tencent.mm.plugin.ipcall.model.h.c> vad = null;
  HashMap<String, Integer> fVB;
  private String jff;
  bb jsg;
  private Context mContext;
  boolean odI;
  private d vbc;
  private HashMap<Long, com.tencent.mm.plugin.ipcall.model.h.c> vbd;
  private HashSet<String> vbe;
  private boolean vbf;
  private View.OnClickListener vbg;
  
  public c(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(25613);
    this.vbd = new HashMap();
    this.fVB = new HashMap();
    this.vbe = new HashSet();
    this.vbf = false;
    this.odI = false;
    this.vbg = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25611);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallAddressAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if ((paramAnonymousView.getTag() instanceof Integer))
        {
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          localObject = c.this.Jd(i);
          paramAnonymousView = new Intent(c.a(c.this), IPCallUserProfileUI.class);
          paramAnonymousView.putExtra("IPCallProfileUI_contactid", ((com.tencent.mm.plugin.ipcall.model.h.c)localObject).field_contactId);
          paramAnonymousView.putExtra("IPCallProfileUI_systemUsername", ((com.tencent.mm.plugin.ipcall.model.h.c)localObject).field_systemAddressBookUsername);
          paramAnonymousView.putExtra("IPCallProfileUI_wechatUsername", ((com.tencent.mm.plugin.ipcall.model.h.c)localObject).field_wechatUsername);
          localObject = c.b(c.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahE(), "com/tencent/mm/plugin/ipcall/ui/IPCallAddressAdapter$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject).startActivity((Intent)paramAnonymousView.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressAdapter$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(25611);
      }
    };
    this.jsg = new bb();
    xs(true);
    this.mContext = paramContext;
    this.vbc = new d(paramContext);
    p.aEA().a(this);
    AppMethodBeat.o(25613);
  }
  
  private static String a(com.tencent.mm.plugin.ipcall.model.h.c paramc, String paramString)
  {
    AppMethodBeat.i(25622);
    if ((paramc != null) && (paramc.vae != null))
    {
      paramc = paramc.vae.iterator();
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
  
  private static String aoN(String paramString)
  {
    AppMethodBeat.i(25623);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(25623);
      return "";
    }
    if (paramString.startsWith(com.tencent.mm.plugin.ipcall.model.h.b.fVA))
    {
      AppMethodBeat.o(25623);
      return "#";
    }
    paramString = paramString.toUpperCase().substring(0, 1);
    AppMethodBeat.o(25623);
    return paramString;
  }
  
  private void dhm()
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
        localObject2 = aoN(((com.tencent.mm.plugin.ipcall.model.h.c)localObject2).field_sortKey);
        if (i == 0) {
          this.fVB.put(localObject2, Integer.valueOf(i));
        }
        for (;;)
        {
          i += 1;
          localCursor.moveToNext();
          localObject1 = localObject2;
          break;
          if ((localObject1 != null) && (!((String)localObject2).equals(localObject1))) {
            this.fVB.put(localObject2, Integer.valueOf(i));
          }
        }
        AppMethodBeat.o(25628);
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.IPCallAddressAdapter", "initSectionPosMap error: %s", new Object[] { localException.getMessage() });
      }
    }
    else
    {
      return;
    }
    label153:
    AppMethodBeat.o(25628);
  }
  
  public final void DG(String paramString)
  {
    AppMethodBeat.i(25626);
    if (this.vbe.contains(paramString)) {
      ar.f(new Runnable()
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
  
  public final void JN(String paramString)
  {
    AppMethodBeat.i(25617);
    this.jff = paramString;
    if (bu.isNullOrNil(this.jff)) {}
    for (this.vbf = false;; this.vbf = true)
    {
      this.Jvm.clear();
      ZD();
      notifyDataSetChanged();
      AppMethodBeat.o(25617);
      return;
    }
  }
  
  public final com.tencent.mm.plugin.ipcall.model.h.c Jd(int paramInt)
  {
    AppMethodBeat.i(25616);
    com.tencent.mm.plugin.ipcall.model.h.c localc = (com.tencent.mm.plugin.ipcall.model.h.c)super.getItem(paramInt);
    AppMethodBeat.o(25616);
    return localc;
  }
  
  public final void ZD()
  {
    AppMethodBeat.i(25618);
    Cursor localCursor;
    if (!this.vbf) {
      localCursor = i.dgE().dhf();
    }
    for (;;)
    {
      if (localCursor != null) {
        localCursor.moveToFirst();
      }
      setCursor(localCursor);
      dhm();
      AppMethodBeat.o(25618);
      return;
      this.odI = true;
      localCursor = i.dgE().aoD(this.jff);
      this.odI = false;
    }
  }
  
  public final void ZE()
  {
    AppMethodBeat.i(25620);
    super.dhl();
    ZD();
    AppMethodBeat.o(25620);
  }
  
  public final int dhk()
  {
    AppMethodBeat.i(25615);
    int i = super.getCount();
    AppMethodBeat.o(25615);
    return i;
  }
  
  public final void dhl()
  {
    AppMethodBeat.i(25619);
    super.dhl();
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
      paramView.vbs = localView.findViewById(2131301153);
      paramView.vbt = localView.findViewById(2131299159);
      paramView.fTj = ((ImageView)localView.findViewById(2131297008));
      paramView.jeW = ((TextView)localView.findViewById(2131302867));
      paramView.vbk = ((TextView)localView.findViewById(2131303238));
      paramView.vbl = ((LinearLayout)localView.findViewById(2131303812));
      paramView.vbm = ((TextView)localView.findViewById(2131303815));
      paramView.vbn = ((TextView)localView.findViewById(2131303816));
      paramView.vbo = ((TextView)localView.findViewById(2131296493));
      paramView.vbp = ((TextView)localView.findViewById(2131296482));
      paramView.vbq = ((ImageView)localView.findViewById(2131296483));
      paramView.vbr = localView.findViewById(2131301156);
      paramView.vbr.setClickable(true);
      paramView.vbu = ((ImageView)localView.findViewById(2131299154));
      localView.setTag(paramView);
    }
    paramViewGroup = (b)localView.getTag();
    paramViewGroup.vbr.setClickable(true);
    paramViewGroup.vbr.setTag(Integer.valueOf(paramInt));
    paramViewGroup.vbu.setVisibility(8);
    int j;
    int i;
    if (Iw(paramInt))
    {
      paramViewGroup.jeW.setVisibility(8);
      paramViewGroup.vbk.setVisibility(8);
      paramViewGroup.vbl.setVisibility(8);
      paramViewGroup.fTj.setVisibility(8);
      paramViewGroup.fTj.setTag(null);
      paramViewGroup.vbp.setVisibility(8);
      paramViewGroup.vbo.setVisibility(8);
      paramViewGroup.vbq.setVisibility(8);
      j = 1;
      i = j;
      if (Jd(paramInt + 1) != null)
      {
        i = j;
        if (Jd(paramInt) != null)
        {
          i = j;
          if (!aoN(Jd(paramInt + 1).field_sortKey).equals(aoN(Jd(paramInt).field_sortKey))) {
            i = 0;
          }
        }
      }
      if ((paramInt + 1 != getCount()) && (i != 0)) {
        break label1583;
      }
      paramViewGroup.vbt.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(25621);
      return localView;
      com.tencent.mm.plugin.ipcall.model.h.c localc = Jd(paramInt);
      if (localc != null)
      {
        if (bu.isNullOrNil(localc.field_systemAddressBookUsername)) {
          break label1430;
        }
        paramViewGroup.jeW.setVisibility(0);
        if (!this.vbf) {
          break label919;
        }
        paramViewGroup.vbk.setVisibility(0);
        paramView = (FrameLayout.LayoutParams)paramViewGroup.vbs.getLayoutParams();
        paramView.height = ((int)paramViewGroup.vbk.getContext().getResources().getDimension(2131165717));
        paramViewGroup.vbs.setLayoutParams(paramView);
        paramView = (RelativeLayout.LayoutParams)paramViewGroup.fTj.getLayoutParams();
        paramView.height = ((int)paramViewGroup.fTj.getContext().getResources().getDimension(2131165713));
        paramView.width = ((int)paramViewGroup.fTj.getContext().getResources().getDimension(2131165713));
        paramViewGroup.fTj.setLayoutParams(paramView);
        label602:
        if ((!this.vbf) || (localc.vae != null) || (vad == null) || (!vad.containsKey(localc.field_contactId))) {
          break label1032;
        }
        localc.vae = ((com.tencent.mm.plugin.ipcall.model.h.c)vad.get(localc.field_contactId)).vae;
        label659:
        if ((bu.isNullOrNil(this.jff)) || ((!bu.G(this.jff.charAt(0))) && (!this.jff.startsWith("+")))) {
          break label1083;
        }
        paramView = com.tencent.mm.plugin.fts.a.f.b(a(localc, this.jff), bb.aSe(this.jff));
        paramViewGroup.vbk.setText(paramView);
        paramView = com.tencent.mm.plugin.fts.a.f.b(localc.field_systemAddressBookUsername, this.jff);
        paramViewGroup.jeW.setText(paramView);
        label745:
        paramView = paramViewGroup.fTj;
        if (paramView != null)
        {
          paramView.setVisibility(0);
          paramView.setTag(null);
          paramView.setImageResource(2131232743);
          if (localc != null)
          {
            if ((bu.isNullOrNil(localc.field_contactId)) || (bu.isNullOrNil(localc.field_wechatUsername))) {
              break label1451;
            }
            this.vbc.a(localc.field_contactId, localc.field_wechatUsername, paramView);
            label816:
            if (!bu.isNullOrNil(localc.field_wechatUsername)) {
              this.vbe.add(localc.field_wechatUsername);
            }
          }
        }
        paramViewGroup.vbl.setVisibility(8);
        paramView = aoN(localc.field_sortKey);
        if (paramInt != 0) {
          break label1505;
        }
        paramViewGroup.vbo.setVisibility(0);
        paramViewGroup.vbo.setText(paramView);
        paramViewGroup.vbp.setVisibility(8);
      }
      for (;;)
      {
        paramViewGroup.vbr.setVisibility(8);
        paramViewGroup.vbq.setVisibility(8);
        paramViewGroup.vbq.setOnClickListener(this.vbg);
        break;
        label919:
        paramViewGroup.vbk.setVisibility(8);
        paramView = (FrameLayout.LayoutParams)paramViewGroup.vbs.getLayoutParams();
        paramView.height = ((int)paramViewGroup.vbk.getContext().getResources().getDimension(2131165716));
        paramViewGroup.vbs.setLayoutParams(paramView);
        paramView = (RelativeLayout.LayoutParams)paramViewGroup.fTj.getLayoutParams();
        paramView.height = ((int)paramViewGroup.fTj.getContext().getResources().getDimension(2131165714));
        paramView.width = ((int)paramViewGroup.fTj.getContext().getResources().getDimension(2131165714));
        paramViewGroup.fTj.setLayoutParams(paramView);
        break label602;
        label1032:
        if ((!this.vbf) || (localc.vae != null) || ((vad != null) && (!vad.containsKey(localc.field_contactId)))) {
          break label659;
        }
        localc.vae = com.tencent.mm.plugin.ipcall.model.h.b.aoA(localc.field_contactId);
        break label659;
        label1083:
        if ((!bu.isNullOrNil(this.jff)) && (!bu.G(this.jff.charAt(0))))
        {
          String str1 = localc.field_systemAddressBookUsername;
          Object localObject = localc.field_systemAddressBookUsername;
          paramView = this.jff;
          if ((bu.isNullOrNil(paramView)) || (bu.isNullOrNil((String)localObject))) {
            paramView = "";
          }
          label1402:
          for (;;)
          {
            paramView = com.tencent.mm.plugin.fts.a.f.b(str1, paramView);
            paramViewGroup.jeW.setText(paramView);
            paramViewGroup.vbk.setText(a(localc, this.jff));
            break;
            if ((!bu.aSm(paramView)) && (bu.aSn(paramView)))
            {
              ArrayList localArrayList = new ArrayList();
              i = 0;
              String str2;
              while (i < ((String)localObject).length())
              {
                str2 = ((String)localObject).substring(i, i + 1);
                localArrayList.add(new a(com.tencent.mm.platformtools.f.Jk(str2), str2));
                i += 1;
              }
              i = 2;
              while (i <= ((String)localObject).length())
              {
                j = 0;
                while (j <= ((String)localObject).length() - i)
                {
                  str2 = ((String)localObject).substring(j, j + i);
                  localArrayList.add(new a(com.tencent.mm.platformtools.f.Jk(str2), str2));
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
                if (((a)localObject).vbi.contains(paramView))
                {
                  paramView = ((a)localObject).vbj;
                  break;
                }
                i += 1;
              }
            }
          }
        }
        if (!bu.isNullOrNil(this.jff)) {
          break label745;
        }
        paramViewGroup.jeW.setText(localc.field_systemAddressBookUsername);
        break label745;
        label1430:
        paramViewGroup.jeW.setVisibility(8);
        paramViewGroup.vbk.setVisibility(8);
        break label745;
        label1451:
        if (!bu.isNullOrNil(localc.field_contactId))
        {
          this.vbc.d(localc.field_contactId, paramView);
          break label816;
        }
        if (bu.isNullOrNil(localc.field_wechatUsername)) {
          break label816;
        }
        this.vbc.f(localc.field_wechatUsername, paramView);
        break label816;
        label1505:
        if (!aoN(Jd(paramInt - 1).field_sortKey).equals(paramView))
        {
          paramViewGroup.vbo.setVisibility(0);
          paramViewGroup.vbo.setText(paramView);
          paramViewGroup.vbp.setVisibility(8);
        }
        else
        {
          paramViewGroup.vbo.setVisibility(8);
          paramViewGroup.vbo.setText("");
          paramViewGroup.vbp.setVisibility(8);
        }
      }
      label1583:
      paramViewGroup.vbt.setVisibility(0);
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
    this.vbd.clear();
    super.notifyDataSetChanged();
    AppMethodBeat.o(25627);
  }
  
  final class a
  {
    String vbi;
    String vbj;
    
    public a(String paramString1, String paramString2)
    {
      this.vbj = paramString2;
      this.vbi = paramString1;
    }
  }
  
  final class b
  {
    ImageView fTj;
    TextView jeW;
    TextView vbk;
    LinearLayout vbl;
    TextView vbm;
    TextView vbn;
    TextView vbo;
    TextView vbp;
    ImageView vbq;
    View vbr;
    View vbs;
    View vbt;
    ImageView vbu;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.c
 * JD-Core Version:    0.7.0.1
 */