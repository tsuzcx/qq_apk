package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ai.m;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.c;
import com.tencent.mm.model.q;
import com.tencent.mm.n.a;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.EllipsizeTextView;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.MaskLayout.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class SelectMemberUI$b
  extends BaseAdapter
{
  private List<SelectMemberUI.a> bSN = new ArrayList();
  private u dnL;
  private String dpj;
  public String drv;
  private String drx = null;
  private List<SelectMemberUI.a> dry = new ArrayList(0);
  public final String dse = new String(Character.toChars(91));
  HashMap<String, Integer> dsf = new HashMap();
  volatile boolean isLoading = false;
  private Context mContext;
  
  public SelectMemberUI$b(SelectMemberUI paramSelectMemberUI, Context paramContext, u paramu, String paramString1, String paramString2)
  {
    this.dnL = paramu;
    this.dpj = paramString1;
    this.drx = paramString2;
    this.mContext = paramContext;
  }
  
  private String c(ad paramad)
  {
    String str1;
    if (!bk.bl(paramad.field_conRemark))
    {
      str1 = paramad.field_conRemark;
      if (!bk.bl(str1)) {
        break label102;
      }
      str1 = paramad.Bp();
    }
    label102:
    for (;;)
    {
      String str2 = str1;
      if (!a.gR(paramad.field_type))
      {
        paramad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fx().Id(paramad.field_username);
        str2 = str1;
        if (paramad != null)
        {
          str2 = str1;
          if (!bk.bl(paramad.field_conRemark)) {
            str2 = paramad.field_conRemark;
          }
        }
      }
      return str2;
      str1 = SelectMemberUI.a(this.dnL, paramad.field_username);
      break;
    }
  }
  
  public final void G(List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.bSN.clear();
    int i = 0;
    if (i < paramList.size())
    {
      ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl((String)paramList.get(i));
      if ((this.dsb.xN()) || (!q.gS(localad.field_username)))
      {
        boolean bool = localad.field_username.equals(this.drx);
        if (((!bool) || (SelectMemberUI.e(this.dsb))) && (!this.dsb.xV().contains(localad.field_username)))
        {
          if ((!bool) || (!SelectMemberUI.e(this.dsb))) {
            break label166;
          }
          this.bSN.add(0, new SelectMemberUI.a(this.dsb, localad));
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label166:
        this.bSN.add(new SelectMemberUI.a(this.dsb, localad));
      }
    }
    Collections.sort(this.bSN, new SelectMemberUI.b.6(this));
    this.dry = this.bSN;
  }
  
  public final void eV(String paramString)
  {
    y.i("MicroMsg.SelectMemberAdapter", "[setMemberListBySearch]");
    ArrayList localArrayList = new ArrayList();
    if (!bk.bl(paramString))
    {
      Iterator localIterator = this.dry.iterator();
      while (localIterator.hasNext())
      {
        SelectMemberUI.a locala = (SelectMemberUI.a)localIterator.next();
        if ((locala != null) && (locala.dnp != null) && (locala.type == 1))
        {
          Object localObject = locala.dnp;
          if ((((ao)localObject).field_conRemark != null) && (((ao)localObject).field_conRemark.contains(paramString)))
          {
            localArrayList.add(locala);
          }
          else if ((!bk.bl(SeeRoomMemberUI.a(this.dnL, ((ao)localObject).field_username))) && (SeeRoomMemberUI.a(this.dnL, ((ao)localObject).field_username).contains(paramString)))
          {
            localArrayList.add(locala);
          }
          else if ((((ad)localObject).Bp() != null) && (((ad)localObject).Bp().contains(paramString)))
          {
            localArrayList.add(locala);
          }
          else if ((((ad)localObject).vn() != null) && (((ad)localObject).vn().contains(paramString)))
          {
            localArrayList.add(locala);
          }
          else if ((((ad)localObject).vk() != null) && (((ad)localObject).vk().contains(paramString)))
          {
            localArrayList.add(locala);
          }
          else if ((((ao)localObject).field_username != null) && (((ao)localObject).field_username.contains(paramString)))
          {
            localArrayList.add(locala);
          }
          else if (!a.gR(((ao)localObject).field_type))
          {
            localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fx().Id(((ao)localObject).field_username);
            if ((localObject != null) && (((bv)localObject).field_conRemark != null) && (((bv)localObject).field_conRemark.contains(paramString))) {
              localArrayList.add(locala);
            }
          }
        }
      }
      this.bSN = localArrayList;
      return;
    }
    this.bSN = this.dry;
  }
  
  public final int getCount()
  {
    if ((this.bSN == null) || (this.isLoading)) {
      return 0;
    }
    return this.bSN.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, a.f.select_member_item, null);
      paramViewGroup = new SelectMemberUI.c();
      paramViewGroup.dsk = ((MaskLayout)paramView.findViewById(a.e.select_owner_item_avatar));
      paramViewGroup.drB = ((EllipsizeTextView)paramView.findViewById(a.e.select_owner_item_nick));
      paramViewGroup.drB = ((TextView)paramView.findViewById(a.e.select_owner_item_nick));
      paramViewGroup.dsm = ((ImageButton)paramView.findViewById(a.e.btn_select));
      paramViewGroup.dsn = ((LinearLayout)paramView.findViewById(a.e.btn_select_layout));
      localObject = (WindowManager)this.mContext.getSystemService("window");
      paramViewGroup.drB.setMaxWidth(((WindowManager)localObject).getDefaultDisplay().getWidth() * 2 / 3);
      paramViewGroup.dsl = ((TextView)paramView.findViewById(a.e.select_owner_item_desc));
      paramViewGroup.dsl.setMaxWidth(((WindowManager)localObject).getDefaultDisplay().getWidth() * 2 / 3);
      paramView.setTag(paramViewGroup);
      paramViewGroup.dsm.setOnClickListener(new SelectMemberUI.b.3(this, paramViewGroup));
      paramViewGroup.dsn.setOnClickListener(new SelectMemberUI.b.4(this, paramViewGroup));
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          SelectMemberUI.c localc = (SelectMemberUI.c)paramAnonymousView.getTag();
          SelectMemberUI.b.this.dsb.a(paramAnonymousView, localc.position, paramAnonymousView.getId());
        }
      });
    }
    SelectMemberUI.a locala;
    for (;;)
    {
      locala = go(paramInt);
      paramViewGroup.dsn.setTag(Integer.valueOf(paramInt));
      if (locala != null) {
        break;
      }
      y.e("MicroMsg.SelectMemberAdapter", "null == item! position:%s, count:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()) });
      return paramView;
      paramViewGroup = (SelectMemberUI.c)paramView.getTag();
    }
    ad localad = locala.dnp;
    a.b.a((ImageView)paramViewGroup.dsk.getContentView(), localad.field_username);
    String str;
    if (localad.field_verifyFlag != 0) {
      if (am.a.dVA != null)
      {
        localObject = am.a.dVA.hM(localad.field_verifyFlag);
        if (localObject != null)
        {
          localObject = m.lk((String)localObject);
          paramViewGroup.dsk.a((Bitmap)localObject, MaskLayout.a.uZF);
          str = c(localad);
          localObject = "";
          if (a.gR(localad.field_type)) {
            localObject = localad.cCJ;
          }
          if (bk.bl((String)localObject)) {
            break label596;
          }
          paramViewGroup.dsl.setVisibility(0);
          paramViewGroup.dsl.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.mContext, (CharSequence)localObject, paramViewGroup.dsl.getTextSize()));
          label427:
          if (!ad.aaU(localad.field_username)) {
            break label617;
          }
          ((b)g.r(b.class)).a(this.mContext, paramViewGroup.drB, str, localad.field_openImAppid, localad.field_descWordingId, (int)paramViewGroup.drB.getTextSize());
          label480:
          if (!this.dsb.xS()) {
            break label706;
          }
          paramViewGroup.dsm.setVisibility(0);
          paramViewGroup.dsn.setVisibility(0);
          if (!this.dsb.xT().contains(localad.field_username)) {
            break label643;
          }
          paramViewGroup.dsn.setEnabled(false);
          paramViewGroup.dsm.setEnabled(false);
          paramViewGroup.dsm.setImageResource(a.h.checkbox_selected_grey);
        }
      }
    }
    for (;;)
    {
      paramViewGroup.dsj = locala;
      paramViewGroup.position = paramInt;
      return paramView;
      paramViewGroup.dsk.setMaskDrawable(null);
      break;
      paramViewGroup.dsk.setMaskDrawable(null);
      break;
      paramViewGroup.dsk.setMaskDrawable(null);
      break;
      label596:
      paramViewGroup.dsl.setVisibility(8);
      paramViewGroup.dsl.setText("");
      break label427;
      label617:
      paramViewGroup.drB.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.mContext, str, paramViewGroup.drB.getTextSize()));
      break label480;
      label643:
      paramViewGroup.dsn.setEnabled(true);
      paramViewGroup.dsm.setEnabled(true);
      if (this.dsb.drY.contains(locala.dnp.field_username))
      {
        paramViewGroup.dsm.setImageResource(a.h.checkbox_selected);
      }
      else
      {
        paramViewGroup.dsm.setImageResource(a.h.checkbox_unselected);
        continue;
        label706:
        paramViewGroup.dsm.setVisibility(8);
        paramViewGroup.dsn.setVisibility(8);
      }
    }
  }
  
  public final SelectMemberUI.a go(int paramInt)
  {
    if (this.bSN.size() > paramInt) {
      return (SelectMemberUI.a)this.bSN.get(paramInt);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectMemberUI.b
 * JD-Core Version:    0.7.0.1
 */