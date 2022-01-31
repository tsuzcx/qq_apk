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
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ag.d.a;
import com.tencent.mm.ag.o;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.ipcall.a.g.b;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
  extends r<com.tencent.mm.plugin.ipcall.a.g.c>
  implements d.a
{
  static HashMap<String, com.tencent.mm.plugin.ipcall.a.g.c> lsH = null;
  HashMap<String, Integer> dsf = new HashMap();
  private String feq;
  ar fqH = new ar();
  boolean idd = false;
  private d ltI;
  private HashMap<Long, com.tencent.mm.plugin.ipcall.a.g.c> ltJ = new HashMap();
  private HashSet<String> ltK = new HashSet();
  private boolean ltL = false;
  private View.OnClickListener ltM = new c.1(this);
  private Context mContext;
  
  public c(Context paramContext)
  {
    super(paramContext, null);
    mR(true);
    this.mContext = paramContext;
    this.ltI = new d(paramContext);
    o.JQ().a(this);
  }
  
  private static String FK(String paramString)
  {
    if (bk.bl(paramString)) {
      return "";
    }
    if (paramString.startsWith(b.dse)) {
      return "#";
    }
    return paramString.toUpperCase().substring(0, 1);
  }
  
  private static String a(com.tencent.mm.plugin.ipcall.a.g.c paramc, String paramString)
  {
    if ((paramc != null) && (paramc.lsI != null))
    {
      paramc = paramc.lsI.iterator();
      while (paramc.hasNext())
      {
        String str = (String)paramc.next();
        if (str.contains(paramString)) {
          return str;
        }
      }
    }
    return null;
  }
  
  public final int bcR()
  {
    return super.getCount();
  }
  
  public final void bcS()
  {
    super.bcS();
  }
  
  public final int getCount()
  {
    return super.getCount();
  }
  
  public final int getItemViewType(int paramInt)
  {
    return super.getItemViewType(paramInt);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.context).inflate(R.i.ipcall_address_item, paramViewGroup, false);
      paramView = new c.b(this, (byte)0);
      paramView.ltY = localView.findViewById(R.h.item_header);
      paramView.ltZ = localView.findViewById(R.h.divider_bottom);
      paramView.dpY = ((ImageView)localView.findViewById(R.h.avatar_iv));
      paramView.feh = ((TextView)localView.findViewById(R.h.nickname_tv));
      paramView.ltQ = ((TextView)localView.findViewById(R.h.phonenumber_tv));
      paramView.ltR = ((LinearLayout)localView.findViewById(R.h.recent_info_ll));
      paramView.ltS = ((TextView)localView.findViewById(R.h.recent_state_tv));
      paramView.ltT = ((TextView)localView.findViewById(R.h.recent_time_tv));
      paramView.ltU = ((TextView)localView.findViewById(R.h.address_spell_category_tv));
      paramView.ltV = ((TextView)localView.findViewById(R.h.address_item_category_tv));
      paramView.ltW = ((ImageView)localView.findViewById(R.h.address_item_info));
      paramView.ltX = localView.findViewById(R.h.item_info_ll);
      paramView.ltX.setClickable(true);
      paramView.lua = ((ImageView)localView.findViewById(R.h.divider));
      localView.setTag(paramView);
    }
    paramViewGroup = (c.b)localView.getTag();
    paramViewGroup.ltX.setClickable(true);
    paramViewGroup.ltX.setTag(Integer.valueOf(paramInt));
    paramViewGroup.lua.setVisibility(8);
    int j;
    int i;
    if (sk(paramInt))
    {
      paramViewGroup.feh.setVisibility(8);
      paramViewGroup.ltQ.setVisibility(8);
      paramViewGroup.ltR.setVisibility(8);
      paramViewGroup.dpY.setVisibility(8);
      paramViewGroup.dpY.setTag(null);
      paramViewGroup.ltV.setVisibility(8);
      paramViewGroup.ltU.setVisibility(8);
      paramViewGroup.ltW.setVisibility(8);
      j = 1;
      i = j;
      if (sK(paramInt + 1) != null)
      {
        i = j;
        if (sK(paramInt) != null)
        {
          i = j;
          if (!FK(sK(paramInt + 1).field_sortKey).equals(FK(sK(paramInt).field_sortKey))) {
            i = 0;
          }
        }
      }
      if ((paramInt + 1 == getCount()) || (i == 0))
      {
        paramViewGroup.ltZ.setVisibility(8);
        return localView;
      }
    }
    else
    {
      com.tencent.mm.plugin.ipcall.a.g.c localc = sK(paramInt);
      if (localc != null)
      {
        if (bk.bl(localc.field_systemAddressBookUsername)) {
          break label1418;
        }
        paramViewGroup.feh.setVisibility(0);
        if (!this.ltL) {
          break label907;
        }
        paramViewGroup.ltQ.setVisibility(0);
        paramView = (FrameLayout.LayoutParams)paramViewGroup.ltY.getLayoutParams();
        paramView.height = ((int)paramViewGroup.ltQ.getContext().getResources().getDimension(R.f.address_item_height_with_num));
        paramViewGroup.ltY.setLayoutParams(paramView);
        paramView = (RelativeLayout.LayoutParams)paramViewGroup.dpY.getLayoutParams();
        paramView.height = ((int)paramViewGroup.dpY.getContext().getResources().getDimension(R.f.address_item_avatar_size));
        paramView.width = ((int)paramViewGroup.dpY.getContext().getResources().getDimension(R.f.address_item_avatar_size));
        paramViewGroup.dpY.setLayoutParams(paramView);
        label590:
        if ((!this.ltL) || (localc.lsI != null) || (lsH == null) || (!lsH.containsKey(localc.field_contactId))) {
          break label1020;
        }
        localc.lsI = ((com.tencent.mm.plugin.ipcall.a.g.c)lsH.get(localc.field_contactId)).lsI;
        label647:
        if ((bk.bl(this.feq)) || ((!bk.n(this.feq.charAt(0))) && (!this.feq.startsWith("+")))) {
          break label1071;
        }
        paramView = f.a(a(localc, this.feq), ar.Zs(this.feq));
        paramViewGroup.ltQ.setText(paramView);
        paramView = f.a(localc.field_systemAddressBookUsername, this.feq);
        paramViewGroup.feh.setText(paramView);
        label733:
        paramView = paramViewGroup.dpY;
        if (paramView != null)
        {
          paramView.setVisibility(0);
          paramView.setTag(null);
          paramView.setImageResource(R.g.ipcall_default_avatar);
          if (localc != null)
          {
            if ((bk.bl(localc.field_contactId)) || (bk.bl(localc.field_wechatUsername))) {
              break label1439;
            }
            this.ltI.a(localc.field_contactId, localc.field_wechatUsername, paramView);
            label804:
            if (!bk.bl(localc.field_wechatUsername)) {
              this.ltK.add(localc.field_wechatUsername);
            }
          }
        }
        paramViewGroup.ltR.setVisibility(8);
        paramView = FK(localc.field_sortKey);
        if (paramInt != 0) {
          break label1493;
        }
        paramViewGroup.ltU.setVisibility(0);
        paramViewGroup.ltU.setText(paramView);
        paramViewGroup.ltV.setVisibility(8);
      }
      for (;;)
      {
        paramViewGroup.ltX.setVisibility(8);
        paramViewGroup.ltW.setVisibility(8);
        paramViewGroup.ltW.setOnClickListener(this.ltM);
        break;
        label907:
        paramViewGroup.ltQ.setVisibility(8);
        paramView = (FrameLayout.LayoutParams)paramViewGroup.ltY.getLayoutParams();
        paramView.height = ((int)paramViewGroup.ltQ.getContext().getResources().getDimension(R.f.address_item_height));
        paramViewGroup.ltY.setLayoutParams(paramView);
        paramView = (RelativeLayout.LayoutParams)paramViewGroup.dpY.getLayoutParams();
        paramView.height = ((int)paramViewGroup.dpY.getContext().getResources().getDimension(R.f.address_item_avatar_size_normal));
        paramView.width = ((int)paramViewGroup.dpY.getContext().getResources().getDimension(R.f.address_item_avatar_size_normal));
        paramViewGroup.dpY.setLayoutParams(paramView);
        break label590;
        label1020:
        if ((!this.ltL) || (localc.lsI != null) || ((lsH != null) && (!lsH.containsKey(localc.field_contactId)))) {
          break label647;
        }
        localc.lsI = b.Fz(localc.field_contactId);
        break label647;
        label1071:
        if ((!bk.bl(this.feq)) && (!bk.n(this.feq.charAt(0))))
        {
          String str1 = localc.field_systemAddressBookUsername;
          Object localObject = localc.field_systemAddressBookUsername;
          paramView = this.feq;
          if ((bk.bl(paramView)) || (bk.bl((String)localObject))) {
            paramView = "";
          }
          label1390:
          for (;;)
          {
            paramView = f.a(str1, paramView);
            paramViewGroup.feh.setText(paramView);
            paramViewGroup.ltQ.setText(a(localc, this.feq));
            break;
            if ((!bk.Zz(paramView)) && (bk.ZA(paramView)))
            {
              ArrayList localArrayList = new ArrayList();
              i = 0;
              String str2;
              while (i < ((String)localObject).length())
              {
                str2 = ((String)localObject).substring(i, i + 1);
                localArrayList.add(new c.a(this, g.oY(str2), str2));
                i += 1;
              }
              i = 2;
              while (i <= ((String)localObject).length())
              {
                j = 0;
                while (j <= ((String)localObject).length() - i)
                {
                  str2 = ((String)localObject).substring(j, j + i);
                  localArrayList.add(new c.a(this, g.oY(str2), str2));
                  j += 1;
                }
                i += 1;
              }
              i = 0;
              for (;;)
              {
                if (i >= localArrayList.size()) {
                  break label1390;
                }
                localObject = (c.a)localArrayList.get(i);
                if (((c.a)localObject).ltO.contains(paramView))
                {
                  paramView = ((c.a)localObject).ltP;
                  break;
                }
                i += 1;
              }
            }
          }
        }
        if (!bk.bl(this.feq)) {
          break label733;
        }
        paramViewGroup.feh.setText(localc.field_systemAddressBookUsername);
        break label733;
        label1418:
        paramViewGroup.feh.setVisibility(8);
        paramViewGroup.ltQ.setVisibility(8);
        break label733;
        label1439:
        if (!bk.bl(localc.field_contactId))
        {
          this.ltI.c(localc.field_contactId, paramView);
          break label804;
        }
        if (bk.bl(localc.field_wechatUsername)) {
          break label804;
        }
        this.ltI.d(localc.field_wechatUsername, paramView);
        break label804;
        label1493:
        if (!FK(sK(paramInt - 1).field_sortKey).equals(paramView))
        {
          paramViewGroup.ltU.setVisibility(0);
          paramViewGroup.ltU.setText(paramView);
          paramViewGroup.ltV.setVisibility(8);
        }
        else
        {
          paramViewGroup.ltU.setVisibility(8);
          paramViewGroup.ltU.setText("");
          paramViewGroup.ltV.setVisibility(8);
        }
      }
    }
    paramViewGroup.ltZ.setVisibility(0);
    return localView;
  }
  
  public final int getViewTypeCount()
  {
    return super.getViewTypeCount();
  }
  
  public final void kk(String paramString)
  {
    if (this.ltK.contains(paramString)) {
      ai.d(new c.2(this));
    }
  }
  
  public final void notifyDataSetChanged()
  {
    this.ltJ.clear();
    super.notifyDataSetChanged();
  }
  
  public final void pA(String paramString)
  {
    this.feq = paramString;
    if (bk.bl(this.feq)) {}
    for (this.ltL = false;; this.ltL = true)
    {
      this.uMh.clear();
      yc();
      notifyDataSetChanged();
      return;
    }
  }
  
  public final com.tencent.mm.plugin.ipcall.a.g.c sK(int paramInt)
  {
    return (com.tencent.mm.plugin.ipcall.a.g.c)super.getItem(paramInt);
  }
  
  public final void yc()
  {
    Object localObject2 = null;
    Object localObject1;
    if (!this.ltL) {
      localObject1 = i.bcm().dXw.query("IPCallAddressItem", com.tencent.mm.plugin.ipcall.a.g.d.lsJ, null, null, null, null, "upper(sortKey) asc");
    }
    for (;;)
    {
      if (localObject1 != null) {
        ((Cursor)localObject1).moveToFirst();
      }
      setCursor((Cursor)localObject1);
      if (getCursor() != null)
      {
        Cursor localCursor = getCursor();
        try
        {
          if (localCursor.moveToFirst())
          {
            int i = 0;
            localObject1 = localObject2;
            label77:
            if (!localCursor.isAfterLast())
            {
              localObject2 = new com.tencent.mm.plugin.ipcall.a.g.c();
              ((com.tencent.mm.plugin.ipcall.a.g.c)localObject2).d(localCursor);
              localObject2 = FK(((com.tencent.mm.plugin.ipcall.a.g.c)localObject2).field_sortKey);
              if (i == 0) {
                this.dsf.put(localObject2, Integer.valueOf(i));
              }
              for (;;)
              {
                i += 1;
                localCursor.moveToNext();
                localObject1 = localObject2;
                break label77;
                this.idd = true;
                localObject1 = i.bcm().FC(this.feq);
                this.idd = false;
                break;
                if ((localObject1 != null) && (!((String)localObject2).equals(localObject1))) {
                  this.dsf.put(localObject2, Integer.valueOf(i));
                }
              }
            }
          }
          return;
        }
        catch (Exception localException)
        {
          y.e("MicroMsg.IPCallAddressAdapter", "initSectionPosMap error: %s", new Object[] { localException.getMessage() });
        }
      }
    }
  }
  
  protected final void yd()
  {
    super.bcS();
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.c
 * JD-Core Version:    0.7.0.1
 */