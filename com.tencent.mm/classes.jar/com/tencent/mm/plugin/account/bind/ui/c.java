package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.cf.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.bind.a.b;
import com.tencent.mm.plugin.account.bind.a.d;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.r.a;

public final class c
  extends b
{
  private int[] fdQ;
  private String fdR;
  private b.a fdS;
  private b.b fdT = new c.1(this);
  
  public c(Context paramContext, r.a parama)
  {
    super(paramContext, new com.tencent.mm.plugin.account.friend.a.a());
    this.uMi = parama;
    this.context = paramContext;
  }
  
  public final void a(b.a parama)
  {
    this.fdS = parama;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    com.tencent.mm.plugin.account.friend.a.a locala = (com.tencent.mm.plugin.account.friend.a.a)getItem(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.context, a.f.mobile_friend_item, null);
      paramViewGroup = new c.a(this, paramView);
      paramViewGroup.fdY = ((TextView)paramView.findViewById(a.e.mobile_friend_name));
      paramView.setTag(paramViewGroup);
      label55:
      paramViewGroup.fdX = paramInt;
      paramViewGroup.bIW = locala.Wv();
      paramViewGroup.status = locala.status;
      paramViewGroup.fdY.setText(locala.Wx());
      switch (locala.status)
      {
      }
    }
    for (;;)
    {
      switch (locala.ebQ)
      {
      default: 
        return paramView;
        paramViewGroup = (c.a)paramView.getTag();
        break label55;
        if (locala.ebQ == 2)
        {
          paramViewGroup.fdZ.setClickable(false);
          paramViewGroup.fdZ.setBackgroundDrawable(null);
          paramViewGroup.eXu.setText(a.i.friend_invited);
          paramViewGroup.eXu.setTextColor(this.context.getResources().getColor(a.b.lightgrey));
        }
        else
        {
          paramViewGroup.fdZ.setClickable(true);
          paramViewGroup.fdZ.setBackgroundResource(a.d.btn_solid_green);
          paramViewGroup.eXu.setText(a.i.friend_invite);
          paramViewGroup.eXu.setTextColor(this.context.getResources().getColor(a.b.white));
          continue;
          y.d("MicroMsg.MobileFriendAdapter", "username:%s", new Object[] { locala.getUsername() });
          if ((((j)g.r(j.class)).Fw().abg(locala.getUsername())) || (q.Gj().equals(locala.getUsername())))
          {
            paramViewGroup.fdZ.setClickable(false);
            paramViewGroup.fdZ.setBackgroundDrawable(null);
            paramViewGroup.eXu.setText(a.i.friend_added);
            paramViewGroup.eXu.setTextColor(this.context.getResources().getColor(a.b.lightgrey));
          }
          else if (locala.ebQ == 2)
          {
            paramViewGroup.fdZ.setClickable(false);
            paramViewGroup.fdZ.setBackgroundDrawable(null);
            paramViewGroup.eXu.setText(a.i.friend_waiting_ask);
            paramViewGroup.eXu.setTextColor(this.context.getResources().getColor(a.b.lightgrey));
          }
          else
          {
            paramViewGroup.fdZ.setClickable(true);
            paramViewGroup.fdZ.setBackgroundResource(a.d.btn_solid_green);
            paramViewGroup.eXu.setText(a.i.friend_add);
            paramViewGroup.eXu.setTextColor(this.context.getResources().getColor(a.b.white));
          }
        }
        break;
      }
    }
    paramViewGroup.eXu.setVisibility(4);
    paramViewGroup.fea.setVisibility(0);
    return paramView;
    paramViewGroup.eXu.setVisibility(0);
    paramViewGroup.fea.setVisibility(4);
    return paramView;
  }
  
  public final void pA(String paramString)
  {
    this.fdR = bk.pl(paramString.trim());
    bcS();
    yc();
  }
  
  public final void yc()
  {
    bcS();
    Object localObject = (com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg();
    String str = this.fdR;
    StringBuilder localStringBuilder = new StringBuilder();
    if ((str != null) && (str.length() > 0))
    {
      localStringBuilder.append(" and ( ");
      localStringBuilder.append("addr_upload2.realname like '%" + str + "%' or ");
      localStringBuilder.append("addr_upload2.realnamepyinitial like '%" + str + "%' or ");
      localStringBuilder.append("addr_upload2.realnamequanpin like '%" + str + "%' or ");
      localStringBuilder.append("addr_upload2.username like '%" + str + "%' or ");
      localStringBuilder.append("addr_upload2.nickname like '%" + str + "%' or ");
      localStringBuilder.append("addr_upload2.nicknamepyinitial like '%" + str + "%' or ");
      localStringBuilder.append("addr_upload2.nicknamequanpin like '%" + str + "%' )");
    }
    localStringBuilder.append(" and (");
    localStringBuilder.append("addr_upload2.status=1");
    localStringBuilder.append(" or ");
    localStringBuilder.append("addr_upload2.status=2");
    localStringBuilder.append(")");
    str = (String)g.DP().Dz().get(6, null);
    if ((str != null) && (!str.equals(""))) {}
    for (localObject = ((com.tencent.mm.plugin.account.friend.a.b)localObject).dXo.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0 and moblie <> " + str + localStringBuilder.toString() + " order by  case when status = 1 then 0  when status = 65536 then 1  when status = 2 then 2 else 3 end  , realnamepyinitial", null, 0);; localObject = ((com.tencent.mm.plugin.account.friend.a.b)localObject).dXo.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0" + localStringBuilder.toString() + " order by  case when status = 1 then 0  when status = 65536 then 1  when status = 2 then 2 else 3 end  , realnamepyinitial", null, 0))
    {
      setCursor((Cursor)localObject);
      this.fdQ = new int[getCount()];
      if ((this.fdS != null) && (this.fdR != null)) {
        this.fdS.jU(getCursor().getCount());
      }
      notifyDataSetChanged();
      return;
    }
  }
  
  protected final void yd()
  {
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.c
 * JD-Core Version:    0.7.0.1
 */