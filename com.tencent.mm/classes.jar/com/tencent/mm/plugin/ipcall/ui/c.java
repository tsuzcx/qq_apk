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
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.AvatarStorage.a;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.ipcall.model.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
  extends x<com.tencent.mm.plugin.ipcall.model.h.c>
  implements AvatarStorage.a
{
  static HashMap<String, com.tencent.mm.plugin.ipcall.model.h.c> JJR = null;
  private d JKQ;
  private HashMap<Long, com.tencent.mm.plugin.ipcall.model.h.c> JKR;
  private HashSet<String> JKS;
  private boolean JKT;
  private View.OnClickListener JKU;
  HashMap<String, Integer> lNs;
  private Context mContext;
  private String pRp;
  PhoneFormater qfC;
  boolean vDm;
  
  public c(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(25613);
    this.JKR = new HashMap();
    this.lNs = new HashMap();
    this.JKS = new HashSet();
    this.JKT = false;
    this.vDm = false;
    this.JKU = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25611);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/IPCallAddressAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        if ((paramAnonymousView.getTag() instanceof Integer))
        {
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          localObject = c.this.Zk(i);
          paramAnonymousView = new Intent(c.a(c.this), IPCallUserProfileUI.class);
          paramAnonymousView.putExtra("IPCallProfileUI_contactid", ((com.tencent.mm.plugin.ipcall.model.h.c)localObject).field_contactId);
          paramAnonymousView.putExtra("IPCallProfileUI_systemUsername", ((com.tencent.mm.plugin.ipcall.model.h.c)localObject).field_systemAddressBookUsername);
          paramAnonymousView.putExtra("IPCallProfileUI_wechatUsername", ((com.tencent.mm.plugin.ipcall.model.h.c)localObject).field_wechatUsername);
          localObject = c.b(c.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aYi(), "com/tencent/mm/plugin/ipcall/ui/IPCallAddressAdapter$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject).startActivity((Intent)paramAnonymousView.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressAdapter$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(25611);
      }
    };
    this.qfC = new PhoneFormater();
    Lh(true);
    this.mContext = paramContext;
    this.JKQ = new d(paramContext);
    q.bFp().a(this);
    AppMethodBeat.o(25613);
  }
  
  private static String a(com.tencent.mm.plugin.ipcall.model.h.c paramc, String paramString)
  {
    AppMethodBeat.i(25622);
    if ((paramc != null) && (paramc.JJS != null))
    {
      paramc = paramc.JJS.iterator();
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
  
  private static String aJi(String paramString)
  {
    AppMethodBeat.i(25623);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(25623);
      return "";
    }
    if (paramString.startsWith(com.tencent.mm.plugin.ipcall.model.h.b.lNr))
    {
      AppMethodBeat.o(25623);
      return "#";
    }
    paramString = paramString.toUpperCase().substring(0, 1);
    AppMethodBeat.o(25623);
    return paramString;
  }
  
  private void fSe()
  {
    AppMethodBeat.i(25628);
    if (Fv() != null)
    {
      Cursor localCursor = Fv();
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
        localObject2 = aJi(((com.tencent.mm.plugin.ipcall.model.h.c)localObject2).field_sortKey);
        if (i == 0) {
          this.lNs.put(localObject2, Integer.valueOf(i));
        }
        for (;;)
        {
          i += 1;
          localCursor.moveToNext();
          localObject1 = localObject2;
          break;
          if ((localObject1 != null) && (!((String)localObject2).equals(localObject1))) {
            this.lNs.put(localObject2, Integer.valueOf(i));
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
  
  public final void LM(String paramString)
  {
    AppMethodBeat.i(25626);
    if (this.JKS.contains(paramString)) {
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
  
  public final void SM(String paramString)
  {
    AppMethodBeat.i(25617);
    this.pRp = paramString;
    if (Util.isNullOrNil(this.pRp)) {}
    for (this.JKT = false;; this.JKT = true)
    {
      this.adDw.clear();
      aNy();
      notifyDataSetChanged();
      AppMethodBeat.o(25617);
      return;
    }
  }
  
  public final com.tencent.mm.plugin.ipcall.model.h.c Zk(int paramInt)
  {
    AppMethodBeat.i(25616);
    com.tencent.mm.plugin.ipcall.model.h.c localc = (com.tencent.mm.plugin.ipcall.model.h.c)super.getItem(paramInt);
    AppMethodBeat.o(25616);
    return localc;
  }
  
  public final void aNy()
  {
    AppMethodBeat.i(25618);
    Cursor localCursor;
    if (!this.JKT) {
      localCursor = h.fRw().fRX();
    }
    for (;;)
    {
      if (localCursor != null) {
        localCursor.moveToFirst();
      }
      w(localCursor);
      fSe();
      AppMethodBeat.o(25618);
      return;
      this.vDm = true;
      localCursor = h.fRw().aIY(this.pRp);
      this.vDm = false;
    }
  }
  
  public final void aNz()
  {
    AppMethodBeat.i(25620);
    super.fSd();
    aNy();
    AppMethodBeat.o(25620);
  }
  
  public final int fSc()
  {
    AppMethodBeat.i(25615);
    int i = super.getCount();
    AppMethodBeat.o(25615);
    return i;
  }
  
  public final void fSd()
  {
    AppMethodBeat.i(25619);
    super.fSd();
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
      localView = LayoutInflater.from(this.context).inflate(R.i.gkS, paramViewGroup, false);
      paramView = new b((byte)0);
      paramView.JLg = localView.findViewById(R.h.fLC);
      paramView.JLh = localView.findViewById(R.h.divider_bottom);
      paramView.lKK = ((ImageView)localView.findViewById(R.h.avatar_iv));
      paramView.pRg = ((TextView)localView.findViewById(R.h.nickname_tv));
      paramView.JKY = ((TextView)localView.findViewById(R.h.fTj));
      paramView.JKZ = ((LinearLayout)localView.findViewById(R.h.fUh));
      paramView.JLa = ((TextView)localView.findViewById(R.h.fUi));
      paramView.JLb = ((TextView)localView.findViewById(R.h.fUj));
      paramView.JLc = ((TextView)localView.findViewById(R.h.fqO));
      paramView.JLd = ((TextView)localView.findViewById(R.h.fqH));
      paramView.JLe = ((ImageView)localView.findViewById(R.h.fqI));
      paramView.JLf = localView.findViewById(R.h.fLD);
      paramView.JLf.setClickable(true);
      paramView.JLi = ((ImageView)localView.findViewById(R.h.divider));
      localView.setTag(paramView);
    }
    paramViewGroup = (b)localView.getTag();
    paramViewGroup.JLf.setClickable(true);
    paramViewGroup.JLf.setTag(Integer.valueOf(paramInt));
    paramViewGroup.JLi.setVisibility(8);
    int j;
    int i;
    if (XL(paramInt))
    {
      paramViewGroup.pRg.setVisibility(8);
      paramViewGroup.JKY.setVisibility(8);
      paramViewGroup.JKZ.setVisibility(8);
      paramViewGroup.lKK.setVisibility(8);
      paramViewGroup.lKK.setTag(null);
      paramViewGroup.JLd.setVisibility(8);
      paramViewGroup.JLc.setVisibility(8);
      paramViewGroup.JLe.setVisibility(8);
      j = 1;
      i = j;
      if (Zk(paramInt + 1) != null)
      {
        i = j;
        if (Zk(paramInt) != null)
        {
          i = j;
          if (!aJi(Zk(paramInt + 1).field_sortKey).equals(aJi(Zk(paramInt).field_sortKey))) {
            i = 0;
          }
        }
      }
      if ((paramInt + 1 != getCount()) && (i != 0)) {
        break label1583;
      }
      paramViewGroup.JLh.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(25621);
      return localView;
      com.tencent.mm.plugin.ipcall.model.h.c localc = Zk(paramInt);
      if (localc != null)
      {
        if (Util.isNullOrNil(localc.field_systemAddressBookUsername)) {
          break label1430;
        }
        paramViewGroup.pRg.setVisibility(0);
        if (!this.JKT) {
          break label919;
        }
        paramViewGroup.JKY.setVisibility(0);
        paramView = (FrameLayout.LayoutParams)paramViewGroup.JLg.getLayoutParams();
        paramView.height = ((int)paramViewGroup.JKY.getContext().getResources().getDimension(R.f.fls));
        paramViewGroup.JLg.setLayoutParams(paramView);
        paramView = (RelativeLayout.LayoutParams)paramViewGroup.lKK.getLayoutParams();
        paramView.height = ((int)paramViewGroup.lKK.getContext().getResources().getDimension(R.f.flp));
        paramView.width = ((int)paramViewGroup.lKK.getContext().getResources().getDimension(R.f.flp));
        paramViewGroup.lKK.setLayoutParams(paramView);
        label602:
        if ((!this.JKT) || (localc.JJS != null) || (JJR == null) || (!JJR.containsKey(localc.field_contactId))) {
          break label1032;
        }
        localc.JJS = ((com.tencent.mm.plugin.ipcall.model.h.c)JJR.get(localc.field_contactId)).JJS;
        label659:
        if ((Util.isNullOrNil(this.pRp)) || ((!Util.isNum(this.pRp.charAt(0))) && (!this.pRp.startsWith("+")))) {
          break label1083;
        }
        paramView = com.tencent.mm.plugin.fts.a.f.b(a(localc, this.pRp), PhoneFormater.formatMobileString(this.pRp));
        paramViewGroup.JKY.setText(paramView);
        paramView = com.tencent.mm.plugin.fts.a.f.b(localc.field_systemAddressBookUsername, this.pRp);
        paramViewGroup.pRg.setText(paramView);
        label745:
        paramView = paramViewGroup.lKK;
        if (paramView != null)
        {
          paramView.setVisibility(0);
          paramView.setTag(null);
          paramView.setImageResource(R.g.fnV);
          if (localc != null)
          {
            if ((Util.isNullOrNil(localc.field_contactId)) || (Util.isNullOrNil(localc.field_wechatUsername))) {
              break label1451;
            }
            this.JKQ.a(localc.field_contactId, localc.field_wechatUsername, paramView);
            label816:
            if (!Util.isNullOrNil(localc.field_wechatUsername)) {
              this.JKS.add(localc.field_wechatUsername);
            }
          }
        }
        paramViewGroup.JKZ.setVisibility(8);
        paramView = aJi(localc.field_sortKey);
        if (paramInt != 0) {
          break label1505;
        }
        paramViewGroup.JLc.setVisibility(0);
        paramViewGroup.JLc.setText(paramView);
        paramViewGroup.JLd.setVisibility(8);
      }
      for (;;)
      {
        paramViewGroup.JLf.setVisibility(8);
        paramViewGroup.JLe.setVisibility(8);
        paramViewGroup.JLe.setOnClickListener(this.JKU);
        break;
        label919:
        paramViewGroup.JKY.setVisibility(8);
        paramView = (FrameLayout.LayoutParams)paramViewGroup.JLg.getLayoutParams();
        paramView.height = ((int)paramViewGroup.JKY.getContext().getResources().getDimension(R.f.flr));
        paramViewGroup.JLg.setLayoutParams(paramView);
        paramView = (RelativeLayout.LayoutParams)paramViewGroup.lKK.getLayoutParams();
        paramView.height = ((int)paramViewGroup.lKK.getContext().getResources().getDimension(R.f.flq));
        paramView.width = ((int)paramViewGroup.lKK.getContext().getResources().getDimension(R.f.flq));
        paramViewGroup.lKK.setLayoutParams(paramView);
        break label602;
        label1032:
        if ((!this.JKT) || (localc.JJS != null) || ((JJR != null) && (!JJR.containsKey(localc.field_contactId)))) {
          break label659;
        }
        localc.JJS = com.tencent.mm.plugin.ipcall.model.h.b.aIV(localc.field_contactId);
        break label659;
        label1083:
        if ((!Util.isNullOrNil(this.pRp)) && (!Util.isNum(this.pRp.charAt(0))))
        {
          String str1 = localc.field_systemAddressBookUsername;
          Object localObject = localc.field_systemAddressBookUsername;
          paramView = this.pRp;
          if ((Util.isNullOrNil(paramView)) || (Util.isNullOrNil((String)localObject))) {
            paramView = "";
          }
          label1402:
          for (;;)
          {
            paramView = com.tencent.mm.plugin.fts.a.f.b(str1, paramView);
            paramViewGroup.pRg.setText(paramView);
            paramViewGroup.JKY.setText(a(localc, this.pRp));
            break;
            if ((!Util.isChinese(paramView)) && (Util.isAllAlpha(paramView)))
            {
              ArrayList localArrayList = new ArrayList();
              i = 0;
              String str2;
              while (i < ((String)localObject).length())
              {
                str2 = ((String)localObject).substring(i, i + 1);
                localArrayList.add(new a(com.tencent.mm.platformtools.f.RZ(str2), str2));
                i += 1;
              }
              i = 2;
              while (i <= ((String)localObject).length())
              {
                j = 0;
                while (j <= ((String)localObject).length() - i)
                {
                  str2 = ((String)localObject).substring(j, j + i);
                  localArrayList.add(new a(com.tencent.mm.platformtools.f.RZ(str2), str2));
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
                if (((a)localObject).JKW.contains(paramView))
                {
                  paramView = ((a)localObject).JKX;
                  break;
                }
                i += 1;
              }
            }
          }
        }
        if (!Util.isNullOrNil(this.pRp)) {
          break label745;
        }
        paramViewGroup.pRg.setText(localc.field_systemAddressBookUsername);
        break label745;
        label1430:
        paramViewGroup.pRg.setVisibility(8);
        paramViewGroup.JKY.setVisibility(8);
        break label745;
        label1451:
        if (!Util.isNullOrNil(localc.field_contactId))
        {
          this.JKQ.e(localc.field_contactId, paramView);
          break label816;
        }
        if (Util.isNullOrNil(localc.field_wechatUsername)) {
          break label816;
        }
        this.JKQ.g(localc.field_wechatUsername, paramView);
        break label816;
        label1505:
        if (!aJi(Zk(paramInt - 1).field_sortKey).equals(paramView))
        {
          paramViewGroup.JLc.setVisibility(0);
          paramViewGroup.JLc.setText(paramView);
          paramViewGroup.JLd.setVisibility(8);
        }
        else
        {
          paramViewGroup.JLc.setVisibility(8);
          paramViewGroup.JLc.setText("");
          paramViewGroup.JLd.setVisibility(8);
        }
      }
      label1583:
      paramViewGroup.JLh.setVisibility(0);
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
    this.JKR.clear();
    super.notifyDataSetChanged();
    AppMethodBeat.o(25627);
  }
  
  final class a
  {
    String JKW;
    String JKX;
    
    public a(String paramString1, String paramString2)
    {
      this.JKX = paramString2;
      this.JKW = paramString1;
    }
  }
  
  final class b
  {
    TextView JKY;
    LinearLayout JKZ;
    TextView JLa;
    TextView JLb;
    TextView JLc;
    TextView JLd;
    ImageView JLe;
    View JLf;
    View JLg;
    View JLh;
    ImageView JLi;
    ImageView lKK;
    TextView pRg;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.c
 * JD-Core Version:    0.7.0.1
 */