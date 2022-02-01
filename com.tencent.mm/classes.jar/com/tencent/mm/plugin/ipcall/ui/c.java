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
import com.tencent.mm.plugin.ipcall.model.h.b;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
  extends q<com.tencent.mm.plugin.ipcall.model.h.c>
  implements e.a
{
  static HashMap<String, com.tencent.mm.plugin.ipcall.model.h.c> sDW = null;
  HashMap<String, Integer> fwy;
  private String iiW;
  ba iwa;
  private Context mContext;
  boolean mUj;
  private d sEW;
  private HashMap<Long, com.tencent.mm.plugin.ipcall.model.h.c> sEX;
  private HashSet<String> sEY;
  private boolean sEZ;
  private View.OnClickListener sFa;
  
  public c(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(25613);
    this.sEX = new HashMap();
    this.fwy = new HashMap();
    this.sEY = new HashSet();
    this.sEZ = false;
    this.mUj = false;
    this.sFa = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25611);
        if ((paramAnonymousView.getTag() instanceof Integer))
        {
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          Object localObject = c.this.Fo(i);
          paramAnonymousView = new Intent(c.a(c.this), IPCallUserProfileUI.class);
          paramAnonymousView.putExtra("IPCallProfileUI_contactid", ((com.tencent.mm.plugin.ipcall.model.h.c)localObject).field_contactId);
          paramAnonymousView.putExtra("IPCallProfileUI_systemUsername", ((com.tencent.mm.plugin.ipcall.model.h.c)localObject).field_systemAddressBookUsername);
          paramAnonymousView.putExtra("IPCallProfileUI_wechatUsername", ((com.tencent.mm.plugin.ipcall.model.h.c)localObject).field_wechatUsername);
          localObject = c.b(c.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.adn(), "com/tencent/mm/plugin/ipcall/ui/IPCallAddressAdapter$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject).startActivity((Intent)paramAnonymousView.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressAdapter$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(25611);
      }
    };
    this.iwa = new ba();
    vw(true);
    this.mContext = paramContext;
    this.sEW = new d(paramContext);
    p.auq().a(this);
    AppMethodBeat.o(25613);
  }
  
  private static String a(com.tencent.mm.plugin.ipcall.model.h.c paramc, String paramString)
  {
    AppMethodBeat.i(25622);
    if ((paramc != null) && (paramc.sDX != null))
    {
      paramc = paramc.sDX.iterator();
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
  
  private static String aeg(String paramString)
  {
    AppMethodBeat.i(25623);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(25623);
      return "";
    }
    if (paramString.startsWith(b.fwx))
    {
      AppMethodBeat.o(25623);
      return "#";
    }
    paramString = paramString.toUpperCase().substring(0, 1);
    AppMethodBeat.o(25623);
    return paramString;
  }
  
  private void cHY()
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
        localObject2 = aeg(((com.tencent.mm.plugin.ipcall.model.h.c)localObject2).field_sortKey);
        if (i == 0) {
          this.fwy.put(localObject2, Integer.valueOf(i));
        }
        for (;;)
        {
          i += 1;
          localCursor.moveToNext();
          localObject1 = localObject2;
          break;
          if ((localObject1 != null) && (!((String)localObject2).equals(localObject1))) {
            this.fwy.put(localObject2, Integer.valueOf(i));
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
  
  public final void BW(String paramString)
  {
    AppMethodBeat.i(25617);
    this.iiW = paramString;
    if (bt.isNullOrNil(this.iiW)) {}
    for (this.sEZ = false;; this.sEZ = true)
    {
      this.FNm.clear();
      Wd();
      notifyDataSetChanged();
      AppMethodBeat.o(25617);
      return;
    }
  }
  
  public final com.tencent.mm.plugin.ipcall.model.h.c Fo(int paramInt)
  {
    AppMethodBeat.i(25616);
    com.tencent.mm.plugin.ipcall.model.h.c localc = (com.tencent.mm.plugin.ipcall.model.h.c)super.getItem(paramInt);
    AppMethodBeat.o(25616);
    return localc;
  }
  
  public final void Wd()
  {
    AppMethodBeat.i(25618);
    Cursor localCursor;
    if (!this.sEZ) {
      localCursor = i.cHq().cHR();
    }
    for (;;)
    {
      if (localCursor != null) {
        localCursor.moveToFirst();
      }
      setCursor(localCursor);
      cHY();
      AppMethodBeat.o(25618);
      return;
      this.mUj = true;
      localCursor = i.cHq().adW(this.iiW);
      this.mUj = false;
    }
  }
  
  public final void We()
  {
    AppMethodBeat.i(25620);
    super.cHX();
    Wd();
    AppMethodBeat.o(25620);
  }
  
  public final int cHW()
  {
    AppMethodBeat.i(25615);
    int i = super.getCount();
    AppMethodBeat.o(25615);
    return i;
  }
  
  public final void cHX()
  {
    AppMethodBeat.i(25619);
    super.cHX();
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
      paramView.sFm = localView.findViewById(2131301153);
      paramView.sFn = localView.findViewById(2131299159);
      paramView.fuj = ((ImageView)localView.findViewById(2131297008));
      paramView.iiN = ((TextView)localView.findViewById(2131302867));
      paramView.sFe = ((TextView)localView.findViewById(2131303238));
      paramView.sFf = ((LinearLayout)localView.findViewById(2131303812));
      paramView.sFg = ((TextView)localView.findViewById(2131303815));
      paramView.sFh = ((TextView)localView.findViewById(2131303816));
      paramView.sFi = ((TextView)localView.findViewById(2131296493));
      paramView.sFj = ((TextView)localView.findViewById(2131296482));
      paramView.sFk = ((ImageView)localView.findViewById(2131296483));
      paramView.sFl = localView.findViewById(2131301156);
      paramView.sFl.setClickable(true);
      paramView.sFo = ((ImageView)localView.findViewById(2131299154));
      localView.setTag(paramView);
    }
    paramViewGroup = (b)localView.getTag();
    paramViewGroup.sFl.setClickable(true);
    paramViewGroup.sFl.setTag(Integer.valueOf(paramInt));
    paramViewGroup.sFo.setVisibility(8);
    int j;
    int i;
    if (EJ(paramInt))
    {
      paramViewGroup.iiN.setVisibility(8);
      paramViewGroup.sFe.setVisibility(8);
      paramViewGroup.sFf.setVisibility(8);
      paramViewGroup.fuj.setVisibility(8);
      paramViewGroup.fuj.setTag(null);
      paramViewGroup.sFj.setVisibility(8);
      paramViewGroup.sFi.setVisibility(8);
      paramViewGroup.sFk.setVisibility(8);
      j = 1;
      i = j;
      if (Fo(paramInt + 1) != null)
      {
        i = j;
        if (Fo(paramInt) != null)
        {
          i = j;
          if (!aeg(Fo(paramInt + 1).field_sortKey).equals(aeg(Fo(paramInt).field_sortKey))) {
            i = 0;
          }
        }
      }
      if ((paramInt + 1 != getCount()) && (i != 0)) {
        break label1583;
      }
      paramViewGroup.sFn.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(25621);
      return localView;
      com.tencent.mm.plugin.ipcall.model.h.c localc = Fo(paramInt);
      if (localc != null)
      {
        if (bt.isNullOrNil(localc.field_systemAddressBookUsername)) {
          break label1430;
        }
        paramViewGroup.iiN.setVisibility(0);
        if (!this.sEZ) {
          break label919;
        }
        paramViewGroup.sFe.setVisibility(0);
        paramView = (FrameLayout.LayoutParams)paramViewGroup.sFm.getLayoutParams();
        paramView.height = ((int)paramViewGroup.sFe.getContext().getResources().getDimension(2131165717));
        paramViewGroup.sFm.setLayoutParams(paramView);
        paramView = (RelativeLayout.LayoutParams)paramViewGroup.fuj.getLayoutParams();
        paramView.height = ((int)paramViewGroup.fuj.getContext().getResources().getDimension(2131165713));
        paramView.width = ((int)paramViewGroup.fuj.getContext().getResources().getDimension(2131165713));
        paramViewGroup.fuj.setLayoutParams(paramView);
        label602:
        if ((!this.sEZ) || (localc.sDX != null) || (sDW == null) || (!sDW.containsKey(localc.field_contactId))) {
          break label1032;
        }
        localc.sDX = ((com.tencent.mm.plugin.ipcall.model.h.c)sDW.get(localc.field_contactId)).sDX;
        label659:
        if ((bt.isNullOrNil(this.iiW)) || ((!bt.G(this.iiW.charAt(0))) && (!this.iiW.startsWith("+")))) {
          break label1083;
        }
        paramView = com.tencent.mm.plugin.fts.a.f.a(a(localc, this.iiW), ba.aFK(this.iiW));
        paramViewGroup.sFe.setText(paramView);
        paramView = com.tencent.mm.plugin.fts.a.f.a(localc.field_systemAddressBookUsername, this.iiW);
        paramViewGroup.iiN.setText(paramView);
        label745:
        paramView = paramViewGroup.fuj;
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
            this.sEW.a(localc.field_contactId, localc.field_wechatUsername, paramView);
            label816:
            if (!bt.isNullOrNil(localc.field_wechatUsername)) {
              this.sEY.add(localc.field_wechatUsername);
            }
          }
        }
        paramViewGroup.sFf.setVisibility(8);
        paramView = aeg(localc.field_sortKey);
        if (paramInt != 0) {
          break label1505;
        }
        paramViewGroup.sFi.setVisibility(0);
        paramViewGroup.sFi.setText(paramView);
        paramViewGroup.sFj.setVisibility(8);
      }
      for (;;)
      {
        paramViewGroup.sFl.setVisibility(8);
        paramViewGroup.sFk.setVisibility(8);
        paramViewGroup.sFk.setOnClickListener(this.sFa);
        break;
        label919:
        paramViewGroup.sFe.setVisibility(8);
        paramView = (FrameLayout.LayoutParams)paramViewGroup.sFm.getLayoutParams();
        paramView.height = ((int)paramViewGroup.sFe.getContext().getResources().getDimension(2131165716));
        paramViewGroup.sFm.setLayoutParams(paramView);
        paramView = (RelativeLayout.LayoutParams)paramViewGroup.fuj.getLayoutParams();
        paramView.height = ((int)paramViewGroup.fuj.getContext().getResources().getDimension(2131165714));
        paramView.width = ((int)paramViewGroup.fuj.getContext().getResources().getDimension(2131165714));
        paramViewGroup.fuj.setLayoutParams(paramView);
        break label602;
        label1032:
        if ((!this.sEZ) || (localc.sDX != null) || ((sDW != null) && (!sDW.containsKey(localc.field_contactId)))) {
          break label659;
        }
        localc.sDX = b.adT(localc.field_contactId);
        break label659;
        label1083:
        if ((!bt.isNullOrNil(this.iiW)) && (!bt.G(this.iiW.charAt(0))))
        {
          String str1 = localc.field_systemAddressBookUsername;
          Object localObject = localc.field_systemAddressBookUsername;
          paramView = this.iiW;
          if ((bt.isNullOrNil(paramView)) || (bt.isNullOrNil((String)localObject))) {
            paramView = "";
          }
          label1402:
          for (;;)
          {
            paramView = com.tencent.mm.plugin.fts.a.f.a(str1, paramView);
            paramViewGroup.iiN.setText(paramView);
            paramViewGroup.sFe.setText(a(localc, this.iiW));
            break;
            if ((!bt.aFS(paramView)) && (bt.aFT(paramView)))
            {
              ArrayList localArrayList = new ArrayList();
              i = 0;
              String str2;
              while (i < ((String)localObject).length())
              {
                str2 = ((String)localObject).substring(i, i + 1);
                localArrayList.add(new a(com.tencent.mm.platformtools.f.Br(str2), str2));
                i += 1;
              }
              i = 2;
              while (i <= ((String)localObject).length())
              {
                j = 0;
                while (j <= ((String)localObject).length() - i)
                {
                  str2 = ((String)localObject).substring(j, j + i);
                  localArrayList.add(new a(com.tencent.mm.platformtools.f.Br(str2), str2));
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
                if (((a)localObject).sFc.contains(paramView))
                {
                  paramView = ((a)localObject).sFd;
                  break;
                }
                i += 1;
              }
            }
          }
        }
        if (!bt.isNullOrNil(this.iiW)) {
          break label745;
        }
        paramViewGroup.iiN.setText(localc.field_systemAddressBookUsername);
        break label745;
        label1430:
        paramViewGroup.iiN.setVisibility(8);
        paramViewGroup.sFe.setVisibility(8);
        break label745;
        label1451:
        if (!bt.isNullOrNil(localc.field_contactId))
        {
          this.sEW.c(localc.field_contactId, paramView);
          break label816;
        }
        if (bt.isNullOrNil(localc.field_wechatUsername)) {
          break label816;
        }
        this.sEW.e(localc.field_wechatUsername, paramView);
        break label816;
        label1505:
        if (!aeg(Fo(paramInt - 1).field_sortKey).equals(paramView))
        {
          paramViewGroup.sFi.setVisibility(0);
          paramViewGroup.sFi.setText(paramView);
          paramViewGroup.sFj.setVisibility(8);
        }
        else
        {
          paramViewGroup.sFi.setVisibility(8);
          paramViewGroup.sFi.setText("");
          paramViewGroup.sFj.setVisibility(8);
        }
      }
      label1583:
      paramViewGroup.sFn.setVisibility(0);
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
    this.sEX.clear();
    super.notifyDataSetChanged();
    AppMethodBeat.o(25627);
  }
  
  public final void vZ(String paramString)
  {
    AppMethodBeat.i(25626);
    if (this.sEY.contains(paramString)) {
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
  
  final class a
  {
    String sFc;
    String sFd;
    
    public a(String paramString1, String paramString2)
    {
      this.sFd = paramString2;
      this.sFc = paramString1;
    }
  }
  
  final class b
  {
    ImageView fuj;
    TextView iiN;
    TextView sFe;
    LinearLayout sFf;
    TextView sFg;
    TextView sFh;
    TextView sFi;
    TextView sFj;
    ImageView sFk;
    View sFl;
    View sFm;
    View sFn;
    ImageView sFo;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.c
 * JD-Core Version:    0.7.0.1
 */