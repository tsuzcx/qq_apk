package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
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
import com.tencent.mm.ah.d.a;
import com.tencent.mm.ah.o;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.ipcall.a.g.b;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
  extends p<com.tencent.mm.plugin.ipcall.a.g.c>
  implements d.a
{
  static HashMap<String, com.tencent.mm.plugin.ipcall.a.g.c> nQb = null;
  HashMap<String, Integer> ejN;
  av gIk;
  private String gvZ;
  boolean jTS;
  private Context mContext;
  private d nRb;
  private HashMap<Long, com.tencent.mm.plugin.ipcall.a.g.c> nRc;
  private HashSet<String> nRd;
  private boolean nRe;
  private View.OnClickListener nRf;
  
  public c(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(21997);
    this.nRc = new HashMap();
    this.ejN = new HashMap();
    this.nRd = new HashSet();
    this.nRe = false;
    this.jTS = false;
    this.nRf = new c.1(this);
    this.gIk = new av();
    qp(true);
    this.mContext = paramContext;
    this.nRb = new d(paramContext);
    o.acQ().a(this);
    AppMethodBeat.o(21997);
  }
  
  private static String Rm(String paramString)
  {
    AppMethodBeat.i(22007);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(22007);
      return "";
    }
    if (paramString.startsWith(b.ejM))
    {
      AppMethodBeat.o(22007);
      return "#";
    }
    paramString = paramString.toUpperCase().substring(0, 1);
    AppMethodBeat.o(22007);
    return paramString;
  }
  
  private static String a(com.tencent.mm.plugin.ipcall.a.g.c paramc, String paramString)
  {
    AppMethodBeat.i(22006);
    if ((paramc != null) && (paramc.nQc != null))
    {
      paramc = paramc.nQc.iterator();
      while (paramc.hasNext())
      {
        String str = (String)paramc.next();
        if (str.contains(paramString))
        {
          AppMethodBeat.o(22006);
          return str;
        }
      }
    }
    AppMethodBeat.o(22006);
    return null;
  }
  
  private void bKc()
  {
    AppMethodBeat.i(22012);
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
        Object localObject2 = new com.tencent.mm.plugin.ipcall.a.g.c();
        ((com.tencent.mm.plugin.ipcall.a.g.c)localObject2).convertFrom(localCursor);
        localObject2 = Rm(((com.tencent.mm.plugin.ipcall.a.g.c)localObject2).field_sortKey);
        if (i == 0) {
          this.ejN.put(localObject2, Integer.valueOf(i));
        }
        for (;;)
        {
          i += 1;
          localCursor.moveToNext();
          localObject1 = localObject2;
          break;
          if ((localObject1 != null) && (!((String)localObject2).equals(localObject1))) {
            this.ejN.put(localObject2, Integer.valueOf(i));
          }
        }
        AppMethodBeat.o(22012);
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.IPCallAddressAdapter", "initSectionPosMap error: %s", new Object[] { localException.getMessage() });
      }
    }
    else
    {
      return;
    }
    label153:
    AppMethodBeat.o(22012);
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(22002);
    Cursor localCursor;
    if (!this.nRe) {
      localCursor = i.bJt().bJV();
    }
    for (;;)
    {
      if (localCursor != null) {
        localCursor.moveToFirst();
      }
      setCursor(localCursor);
      bKc();
      AppMethodBeat.o(22002);
      return;
      this.jTS = true;
      localCursor = i.bJt().Rc(this.gvZ);
      this.jTS = false;
    }
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(22004);
    super.bKb();
    Ku();
    AppMethodBeat.o(22004);
  }
  
  public final int bKa()
  {
    AppMethodBeat.i(21999);
    int i = super.getCount();
    AppMethodBeat.o(21999);
    return i;
  }
  
  public final void bKb()
  {
    AppMethodBeat.i(22003);
    super.bKb();
    AppMethodBeat.o(22003);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(21998);
    int i = super.getCount();
    AppMethodBeat.o(21998);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(22008);
    paramInt = super.getItemViewType(paramInt);
    AppMethodBeat.o(22008);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(22005);
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.context).inflate(2130969934, paramViewGroup, false);
      paramView = new c.b(this, (byte)0);
      paramView.nRr = localView.findViewById(2131825263);
      paramView.nRs = localView.findViewById(2131825264);
      paramView.ehv = ((ImageView)localView.findViewById(2131821210));
      paramView.gvQ = ((TextView)localView.findViewById(2131823254));
      paramView.nRj = ((TextView)localView.findViewById(2131825211));
      paramView.nRk = ((LinearLayout)localView.findViewById(2131825267));
      paramView.nRl = ((TextView)localView.findViewById(2131825268));
      paramView.nRm = ((TextView)localView.findViewById(2131825269));
      paramView.nRn = ((TextView)localView.findViewById(2131825262));
      paramView.nRo = ((TextView)localView.findViewById(2131825261));
      paramView.nRp = ((ImageView)localView.findViewById(2131825270));
      paramView.nRq = localView.findViewById(2131825266);
      paramView.nRq.setClickable(true);
      paramView.nRt = ((ImageView)localView.findViewById(2131821148));
      localView.setTag(paramView);
    }
    paramViewGroup = (c.b)localView.getTag();
    paramViewGroup.nRq.setClickable(true);
    paramViewGroup.nRq.setTag(Integer.valueOf(paramInt));
    paramViewGroup.nRt.setVisibility(8);
    int j;
    int i;
    if (xj(paramInt))
    {
      paramViewGroup.gvQ.setVisibility(8);
      paramViewGroup.nRj.setVisibility(8);
      paramViewGroup.nRk.setVisibility(8);
      paramViewGroup.ehv.setVisibility(8);
      paramViewGroup.ehv.setTag(null);
      paramViewGroup.nRo.setVisibility(8);
      paramViewGroup.nRn.setVisibility(8);
      paramViewGroup.nRp.setVisibility(8);
      j = 1;
      i = j;
      if (xM(paramInt + 1) != null)
      {
        i = j;
        if (xM(paramInt) != null)
        {
          i = j;
          if (!Rm(xM(paramInt + 1).field_sortKey).equals(Rm(xM(paramInt).field_sortKey))) {
            i = 0;
          }
        }
      }
      if ((paramInt + 1 != getCount()) && (i != 0)) {
        break label1583;
      }
      paramViewGroup.nRs.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(22005);
      return localView;
      com.tencent.mm.plugin.ipcall.a.g.c localc = xM(paramInt);
      if (localc != null)
      {
        if (bo.isNullOrNil(localc.field_systemAddressBookUsername)) {
          break label1430;
        }
        paramViewGroup.gvQ.setVisibility(0);
        if (!this.nRe) {
          break label919;
        }
        paramViewGroup.nRj.setVisibility(0);
        paramView = (FrameLayout.LayoutParams)paramViewGroup.nRr.getLayoutParams();
        paramView.height = ((int)paramViewGroup.nRj.getContext().getResources().getDimension(2131427492));
        paramViewGroup.nRr.setLayoutParams(paramView);
        paramView = (RelativeLayout.LayoutParams)paramViewGroup.ehv.getLayoutParams();
        paramView.height = ((int)paramViewGroup.ehv.getContext().getResources().getDimension(2131427403));
        paramView.width = ((int)paramViewGroup.ehv.getContext().getResources().getDimension(2131427403));
        paramViewGroup.ehv.setLayoutParams(paramView);
        label602:
        if ((!this.nRe) || (localc.nQc != null) || (nQb == null) || (!nQb.containsKey(localc.field_contactId))) {
          break label1032;
        }
        localc.nQc = ((com.tencent.mm.plugin.ipcall.a.g.c)nQb.get(localc.field_contactId)).nQc;
        label659:
        if ((bo.isNullOrNil(this.gvZ)) || ((!bo.D(this.gvZ.charAt(0))) && (!this.gvZ.startsWith("+")))) {
          break label1083;
        }
        paramView = f.a(a(localc, this.gvZ), av.apx(this.gvZ));
        paramViewGroup.nRj.setText(paramView);
        paramView = f.a(localc.field_systemAddressBookUsername, this.gvZ);
        paramViewGroup.gvQ.setText(paramView);
        label745:
        paramView = paramViewGroup.ehv;
        if (paramView != null)
        {
          paramView.setVisibility(0);
          paramView.setTag(null);
          paramView.setImageResource(2130839181);
          if (localc != null)
          {
            if ((bo.isNullOrNil(localc.field_contactId)) || (bo.isNullOrNil(localc.field_wechatUsername))) {
              break label1451;
            }
            this.nRb.a(localc.field_contactId, localc.field_wechatUsername, paramView);
            label816:
            if (!bo.isNullOrNil(localc.field_wechatUsername)) {
              this.nRd.add(localc.field_wechatUsername);
            }
          }
        }
        paramViewGroup.nRk.setVisibility(8);
        paramView = Rm(localc.field_sortKey);
        if (paramInt != 0) {
          break label1505;
        }
        paramViewGroup.nRn.setVisibility(0);
        paramViewGroup.nRn.setText(paramView);
        paramViewGroup.nRo.setVisibility(8);
      }
      for (;;)
      {
        paramViewGroup.nRq.setVisibility(8);
        paramViewGroup.nRp.setVisibility(8);
        paramViewGroup.nRp.setOnClickListener(this.nRf);
        break;
        label919:
        paramViewGroup.nRj.setVisibility(8);
        paramView = (FrameLayout.LayoutParams)paramViewGroup.nRr.getLayoutParams();
        paramView.height = ((int)paramViewGroup.nRj.getContext().getResources().getDimension(2131427404));
        paramViewGroup.nRr.setLayoutParams(paramView);
        paramView = (RelativeLayout.LayoutParams)paramViewGroup.ehv.getLayoutParams();
        paramView.height = ((int)paramViewGroup.ehv.getContext().getResources().getDimension(2131427490));
        paramView.width = ((int)paramViewGroup.ehv.getContext().getResources().getDimension(2131427490));
        paramViewGroup.ehv.setLayoutParams(paramView);
        break label602;
        label1032:
        if ((!this.nRe) || (localc.nQc != null) || ((nQb != null) && (!nQb.containsKey(localc.field_contactId)))) {
          break label659;
        }
        localc.nQc = b.QZ(localc.field_contactId);
        break label659;
        label1083:
        if ((!bo.isNullOrNil(this.gvZ)) && (!bo.D(this.gvZ.charAt(0))))
        {
          String str1 = localc.field_systemAddressBookUsername;
          Object localObject = localc.field_systemAddressBookUsername;
          paramView = this.gvZ;
          if ((bo.isNullOrNil(paramView)) || (bo.isNullOrNil((String)localObject))) {
            paramView = "";
          }
          label1402:
          for (;;)
          {
            paramView = f.a(str1, paramView);
            paramViewGroup.gvQ.setText(paramView);
            paramViewGroup.nRj.setText(a(localc, this.gvZ));
            break;
            if ((!bo.apE(paramView)) && (bo.apF(paramView)))
            {
              ArrayList localArrayList = new ArrayList();
              i = 0;
              String str2;
              while (i < ((String)localObject).length())
              {
                str2 = ((String)localObject).substring(i, i + 1);
                localArrayList.add(new c.a(this, g.wq(str2), str2));
                i += 1;
              }
              i = 2;
              while (i <= ((String)localObject).length())
              {
                j = 0;
                while (j <= ((String)localObject).length() - i)
                {
                  str2 = ((String)localObject).substring(j, j + i);
                  localArrayList.add(new c.a(this, g.wq(str2), str2));
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
                localObject = (c.a)localArrayList.get(i);
                if (((c.a)localObject).nRh.contains(paramView))
                {
                  paramView = ((c.a)localObject).nRi;
                  break;
                }
                i += 1;
              }
            }
          }
        }
        if (!bo.isNullOrNil(this.gvZ)) {
          break label745;
        }
        paramViewGroup.gvQ.setText(localc.field_systemAddressBookUsername);
        break label745;
        label1430:
        paramViewGroup.gvQ.setVisibility(8);
        paramViewGroup.nRj.setVisibility(8);
        break label745;
        label1451:
        if (!bo.isNullOrNil(localc.field_contactId))
        {
          this.nRb.c(localc.field_contactId, paramView);
          break label816;
        }
        if (bo.isNullOrNil(localc.field_wechatUsername)) {
          break label816;
        }
        this.nRb.e(localc.field_wechatUsername, paramView);
        break label816;
        label1505:
        if (!Rm(xM(paramInt - 1).field_sortKey).equals(paramView))
        {
          paramViewGroup.nRn.setVisibility(0);
          paramViewGroup.nRn.setText(paramView);
          paramViewGroup.nRo.setVisibility(8);
        }
        else
        {
          paramViewGroup.nRn.setVisibility(8);
          paramViewGroup.nRn.setText("");
          paramViewGroup.nRo.setVisibility(8);
        }
      }
      label1583:
      paramViewGroup.nRs.setVisibility(0);
    }
  }
  
  public final int getViewTypeCount()
  {
    AppMethodBeat.i(22009);
    int i = super.getViewTypeCount();
    AppMethodBeat.o(22009);
    return i;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(22011);
    this.nRc.clear();
    super.notifyDataSetChanged();
    AppMethodBeat.o(22011);
  }
  
  public final void re(String paramString)
  {
    AppMethodBeat.i(22010);
    if (this.nRd.contains(paramString)) {
      al.d(new c.2(this));
    }
    AppMethodBeat.o(22010);
  }
  
  public final void wQ(String paramString)
  {
    AppMethodBeat.i(22001);
    this.gvZ = paramString;
    if (bo.isNullOrNil(this.gvZ)) {}
    for (this.nRe = false;; this.nRe = true)
    {
      this.zap.clear();
      Ku();
      notifyDataSetChanged();
      AppMethodBeat.o(22001);
      return;
    }
  }
  
  public final com.tencent.mm.plugin.ipcall.a.g.c xM(int paramInt)
  {
    AppMethodBeat.i(22000);
    com.tencent.mm.plugin.ipcall.a.g.c localc = (com.tencent.mm.plugin.ipcall.a.g.c)super.getItem(paramInt);
    AppMethodBeat.o(22000);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.c
 * JD-Core Version:    0.7.0.1
 */