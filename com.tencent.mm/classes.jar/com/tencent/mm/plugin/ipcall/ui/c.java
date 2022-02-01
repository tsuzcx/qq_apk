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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
  extends s<com.tencent.mm.plugin.ipcall.model.h.c>
  implements e.a
{
  static HashMap<String, com.tencent.mm.plugin.ipcall.model.h.c> ysD = null;
  HashMap<String, Integer> gAI;
  private String kdi;
  PhoneFormater kqv;
  private Context mContext;
  boolean poG;
  private d ytC;
  private HashMap<Long, com.tencent.mm.plugin.ipcall.model.h.c> ytD;
  private HashSet<String> ytE;
  private boolean ytF;
  private View.OnClickListener ytG;
  
  public c(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(25613);
    this.ytD = new HashMap();
    this.gAI = new HashMap();
    this.ytE = new HashSet();
    this.ytF = false;
    this.poG = false;
    this.ytG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25611);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallAddressAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if ((paramAnonymousView.getTag() instanceof Integer))
        {
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          localObject = c.this.Pg(i);
          paramAnonymousView = new Intent(c.a(c.this), IPCallUserProfileUI.class);
          paramAnonymousView.putExtra("IPCallProfileUI_contactid", ((com.tencent.mm.plugin.ipcall.model.h.c)localObject).field_contactId);
          paramAnonymousView.putExtra("IPCallProfileUI_systemUsername", ((com.tencent.mm.plugin.ipcall.model.h.c)localObject).field_systemAddressBookUsername);
          paramAnonymousView.putExtra("IPCallProfileUI_wechatUsername", ((com.tencent.mm.plugin.ipcall.model.h.c)localObject).field_wechatUsername);
          localObject = c.b(c.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallAddressAdapter$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject).startActivity((Intent)paramAnonymousView.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressAdapter$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(25611);
      }
    };
    this.kqv = new PhoneFormater();
    Bh(true);
    this.mContext = paramContext;
    this.ytC = new d(paramContext);
    p.aYn().a(this);
    AppMethodBeat.o(25613);
  }
  
  private static String a(com.tencent.mm.plugin.ipcall.model.h.c paramc, String paramString)
  {
    AppMethodBeat.i(25622);
    if ((paramc != null) && (paramc.ysE != null))
    {
      paramc = paramc.ysE.iterator();
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
  
  private static String aCh(String paramString)
  {
    AppMethodBeat.i(25623);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(25623);
      return "";
    }
    if (paramString.startsWith(com.tencent.mm.plugin.ipcall.model.h.b.gAH))
    {
      AppMethodBeat.o(25623);
      return "#";
    }
    paramString = paramString.toUpperCase().substring(0, 1);
    AppMethodBeat.o(25623);
    return paramString;
  }
  
  private void ebg()
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
        localObject2 = aCh(((com.tencent.mm.plugin.ipcall.model.h.c)localObject2).field_sortKey);
        if (i == 0) {
          this.gAI.put(localObject2, Integer.valueOf(i));
        }
        for (;;)
        {
          i += 1;
          localCursor.moveToNext();
          localObject1 = localObject2;
          break;
          if ((localObject1 != null) && (!((String)localObject2).equals(localObject1))) {
            this.gAI.put(localObject2, Integer.valueOf(i));
          }
        }
        AppMethodBeat.o(25628);
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.IPCallAddressAdapter", "initSectionPosMap error: %s", new Object[] { localException.getMessage() });
      }
    }
    else
    {
      return;
    }
    label153:
    AppMethodBeat.o(25628);
  }
  
  public final void Mr(String paramString)
  {
    AppMethodBeat.i(25626);
    if (this.ytE.contains(paramString)) {
      MMHandlerThread.postToMainThread(new Runnable()
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
  
  public final com.tencent.mm.plugin.ipcall.model.h.c Pg(int paramInt)
  {
    AppMethodBeat.i(25616);
    com.tencent.mm.plugin.ipcall.model.h.c localc = (com.tencent.mm.plugin.ipcall.model.h.c)super.getItem(paramInt);
    AppMethodBeat.o(25616);
    return localc;
  }
  
  public final void SM(String paramString)
  {
    AppMethodBeat.i(25617);
    this.kdi = paramString;
    if (Util.isNullOrNil(this.kdi)) {}
    for (this.ytF = false;; this.ytF = true)
    {
      this.OFH.clear();
      anp();
      notifyDataSetChanged();
      AppMethodBeat.o(25617);
      return;
    }
  }
  
  public final void anp()
  {
    AppMethodBeat.i(25618);
    Cursor localCursor;
    if (!this.ytF) {
      localCursor = i.eay().eaZ();
    }
    for (;;)
    {
      if (localCursor != null) {
        localCursor.moveToFirst();
      }
      setCursor(localCursor);
      ebg();
      AppMethodBeat.o(25618);
      return;
      this.poG = true;
      localCursor = i.eay().aBX(this.kdi);
      this.poG = false;
    }
  }
  
  public final void anq()
  {
    AppMethodBeat.i(25620);
    super.ebf();
    anp();
    AppMethodBeat.o(25620);
  }
  
  public final int ebe()
  {
    AppMethodBeat.i(25615);
    int i = super.getCount();
    AppMethodBeat.o(25615);
    return i;
  }
  
  public final void ebf()
  {
    AppMethodBeat.i(25619);
    super.ebf();
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
      localView = LayoutInflater.from(this.context).inflate(2131495104, paramViewGroup, false);
      paramView = new b((byte)0);
      paramView.ytS = localView.findViewById(2131302811);
      paramView.ytT = localView.findViewById(2131299703);
      paramView.gyr = ((ImageView)localView.findViewById(2131297134));
      paramView.kcZ = ((TextView)localView.findViewById(2131305440));
      paramView.ytK = ((TextView)localView.findViewById(2131305906));
      paramView.ytL = ((LinearLayout)localView.findViewById(2131306615));
      paramView.ytM = ((TextView)localView.findViewById(2131306618));
      paramView.ytN = ((TextView)localView.findViewById(2131306619));
      paramView.ytO = ((TextView)localView.findViewById(2131296567));
      paramView.ytP = ((TextView)localView.findViewById(2131296556));
      paramView.ytQ = ((ImageView)localView.findViewById(2131296557));
      paramView.ytR = localView.findViewById(2131302816);
      paramView.ytR.setClickable(true);
      paramView.ytU = ((ImageView)localView.findViewById(2131299682));
      localView.setTag(paramView);
    }
    paramViewGroup = (b)localView.getTag();
    paramViewGroup.ytR.setClickable(true);
    paramViewGroup.ytR.setTag(Integer.valueOf(paramInt));
    paramViewGroup.ytU.setVisibility(8);
    int j;
    int i;
    if (Ox(paramInt))
    {
      paramViewGroup.kcZ.setVisibility(8);
      paramViewGroup.ytK.setVisibility(8);
      paramViewGroup.ytL.setVisibility(8);
      paramViewGroup.gyr.setVisibility(8);
      paramViewGroup.gyr.setTag(null);
      paramViewGroup.ytP.setVisibility(8);
      paramViewGroup.ytO.setVisibility(8);
      paramViewGroup.ytQ.setVisibility(8);
      j = 1;
      i = j;
      if (Pg(paramInt + 1) != null)
      {
        i = j;
        if (Pg(paramInt) != null)
        {
          i = j;
          if (!aCh(Pg(paramInt + 1).field_sortKey).equals(aCh(Pg(paramInt).field_sortKey))) {
            i = 0;
          }
        }
      }
      if ((paramInt + 1 != getCount()) && (i != 0)) {
        break label1583;
      }
      paramViewGroup.ytT.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(25621);
      return localView;
      com.tencent.mm.plugin.ipcall.model.h.c localc = Pg(paramInt);
      if (localc != null)
      {
        if (Util.isNullOrNil(localc.field_systemAddressBookUsername)) {
          break label1430;
        }
        paramViewGroup.kcZ.setVisibility(0);
        if (!this.ytF) {
          break label919;
        }
        paramViewGroup.ytK.setVisibility(0);
        paramView = (FrameLayout.LayoutParams)paramViewGroup.ytS.getLayoutParams();
        paramView.height = ((int)paramViewGroup.ytK.getContext().getResources().getDimension(2131165735));
        paramViewGroup.ytS.setLayoutParams(paramView);
        paramView = (RelativeLayout.LayoutParams)paramViewGroup.gyr.getLayoutParams();
        paramView.height = ((int)paramViewGroup.gyr.getContext().getResources().getDimension(2131165731));
        paramView.width = ((int)paramViewGroup.gyr.getContext().getResources().getDimension(2131165731));
        paramViewGroup.gyr.setLayoutParams(paramView);
        label602:
        if ((!this.ytF) || (localc.ysE != null) || (ysD == null) || (!ysD.containsKey(localc.field_contactId))) {
          break label1032;
        }
        localc.ysE = ((com.tencent.mm.plugin.ipcall.model.h.c)ysD.get(localc.field_contactId)).ysE;
        label659:
        if ((Util.isNullOrNil(this.kdi)) || ((!Util.isNum(this.kdi.charAt(0))) && (!this.kdi.startsWith("+")))) {
          break label1083;
        }
        paramView = com.tencent.mm.plugin.fts.a.f.b(a(localc, this.kdi), PhoneFormater.formatMobileString(this.kdi));
        paramViewGroup.ytK.setText(paramView);
        paramView = com.tencent.mm.plugin.fts.a.f.b(localc.field_systemAddressBookUsername, this.kdi);
        paramViewGroup.kcZ.setText(paramView);
        label745:
        paramView = paramViewGroup.gyr;
        if (paramView != null)
        {
          paramView.setVisibility(0);
          paramView.setTag(null);
          paramView.setImageResource(2131233183);
          if (localc != null)
          {
            if ((Util.isNullOrNil(localc.field_contactId)) || (Util.isNullOrNil(localc.field_wechatUsername))) {
              break label1451;
            }
            this.ytC.a(localc.field_contactId, localc.field_wechatUsername, paramView);
            label816:
            if (!Util.isNullOrNil(localc.field_wechatUsername)) {
              this.ytE.add(localc.field_wechatUsername);
            }
          }
        }
        paramViewGroup.ytL.setVisibility(8);
        paramView = aCh(localc.field_sortKey);
        if (paramInt != 0) {
          break label1505;
        }
        paramViewGroup.ytO.setVisibility(0);
        paramViewGroup.ytO.setText(paramView);
        paramViewGroup.ytP.setVisibility(8);
      }
      for (;;)
      {
        paramViewGroup.ytR.setVisibility(8);
        paramViewGroup.ytQ.setVisibility(8);
        paramViewGroup.ytQ.setOnClickListener(this.ytG);
        break;
        label919:
        paramViewGroup.ytK.setVisibility(8);
        paramView = (FrameLayout.LayoutParams)paramViewGroup.ytS.getLayoutParams();
        paramView.height = ((int)paramViewGroup.ytK.getContext().getResources().getDimension(2131165734));
        paramViewGroup.ytS.setLayoutParams(paramView);
        paramView = (RelativeLayout.LayoutParams)paramViewGroup.gyr.getLayoutParams();
        paramView.height = ((int)paramViewGroup.gyr.getContext().getResources().getDimension(2131165732));
        paramView.width = ((int)paramViewGroup.gyr.getContext().getResources().getDimension(2131165732));
        paramViewGroup.gyr.setLayoutParams(paramView);
        break label602;
        label1032:
        if ((!this.ytF) || (localc.ysE != null) || ((ysD != null) && (!ysD.containsKey(localc.field_contactId)))) {
          break label659;
        }
        localc.ysE = com.tencent.mm.plugin.ipcall.model.h.b.aBU(localc.field_contactId);
        break label659;
        label1083:
        if ((!Util.isNullOrNil(this.kdi)) && (!Util.isNum(this.kdi.charAt(0))))
        {
          String str1 = localc.field_systemAddressBookUsername;
          Object localObject = localc.field_systemAddressBookUsername;
          paramView = this.kdi;
          if ((Util.isNullOrNil(paramView)) || (Util.isNullOrNil((String)localObject))) {
            paramView = "";
          }
          label1402:
          for (;;)
          {
            paramView = com.tencent.mm.plugin.fts.a.f.b(str1, paramView);
            paramViewGroup.kcZ.setText(paramView);
            paramViewGroup.ytK.setText(a(localc, this.kdi));
            break;
            if ((!Util.isChinese(paramView)) && (Util.isAllAlpha(paramView)))
            {
              ArrayList localArrayList = new ArrayList();
              i = 0;
              String str2;
              while (i < ((String)localObject).length())
              {
                str2 = ((String)localObject).substring(i, i + 1);
                localArrayList.add(new a(com.tencent.mm.platformtools.f.Sh(str2), str2));
                i += 1;
              }
              i = 2;
              while (i <= ((String)localObject).length())
              {
                j = 0;
                while (j <= ((String)localObject).length() - i)
                {
                  str2 = ((String)localObject).substring(j, j + i);
                  localArrayList.add(new a(com.tencent.mm.platformtools.f.Sh(str2), str2));
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
                if (((a)localObject).ytI.contains(paramView))
                {
                  paramView = ((a)localObject).ytJ;
                  break;
                }
                i += 1;
              }
            }
          }
        }
        if (!Util.isNullOrNil(this.kdi)) {
          break label745;
        }
        paramViewGroup.kcZ.setText(localc.field_systemAddressBookUsername);
        break label745;
        label1430:
        paramViewGroup.kcZ.setVisibility(8);
        paramViewGroup.ytK.setVisibility(8);
        break label745;
        label1451:
        if (!Util.isNullOrNil(localc.field_contactId))
        {
          this.ytC.d(localc.field_contactId, paramView);
          break label816;
        }
        if (Util.isNullOrNil(localc.field_wechatUsername)) {
          break label816;
        }
        this.ytC.f(localc.field_wechatUsername, paramView);
        break label816;
        label1505:
        if (!aCh(Pg(paramInt - 1).field_sortKey).equals(paramView))
        {
          paramViewGroup.ytO.setVisibility(0);
          paramViewGroup.ytO.setText(paramView);
          paramViewGroup.ytP.setVisibility(8);
        }
        else
        {
          paramViewGroup.ytO.setVisibility(8);
          paramViewGroup.ytO.setText("");
          paramViewGroup.ytP.setVisibility(8);
        }
      }
      label1583:
      paramViewGroup.ytT.setVisibility(0);
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
    this.ytD.clear();
    super.notifyDataSetChanged();
    AppMethodBeat.o(25627);
  }
  
  final class a
  {
    String ytI;
    String ytJ;
    
    public a(String paramString1, String paramString2)
    {
      this.ytJ = paramString2;
      this.ytI = paramString1;
    }
  }
  
  final class b
  {
    ImageView gyr;
    TextView kcZ;
    TextView ytK;
    LinearLayout ytL;
    TextView ytM;
    TextView ytN;
    TextView ytO;
    TextView ytP;
    ImageView ytQ;
    View ytR;
    View ytS;
    View ytT;
    ImageView ytU;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.c
 * JD-Core Version:    0.7.0.1
 */