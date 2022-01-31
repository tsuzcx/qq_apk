package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.cf.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
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

public final class d
  extends b
{
  private int[] fdQ;
  private String fdR;
  private b.a fdS;
  private b.b fdT = new d.1(this);
  
  public d(Context paramContext, r.a parama)
  {
    super(paramContext, new com.tencent.mm.plugin.account.friend.a.a());
    this.uMi = parama;
    this.context = paramContext;
    mR(true);
  }
  
  private static String a(com.tencent.mm.plugin.account.friend.a.a parama)
  {
    if (parama.fff == 123) {
      return "#";
    }
    return String.valueOf((char)parama.fff);
  }
  
  public final void a(b.a parama)
  {
    this.fdS = parama;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    com.tencent.mm.plugin.account.friend.a.a locala = (com.tencent.mm.plugin.account.friend.a.a)getItem(paramInt);
    label156:
    label188:
    Object localObject;
    if (paramView == null)
    {
      paramView = View.inflate(this.context, a.f.friend_list_item, null);
      paramViewGroup = new a(paramView);
      paramView.setTag(paramViewGroup);
      paramViewGroup.fdX = paramInt;
      paramViewGroup.account = locala.Wv();
      paramViewGroup.status = locala.status;
      paramViewGroup.feh.setText(locala.Wx());
      paramViewGroup.fei.setText(this.context.getString(a.i.friend_weixin) + locala.WA());
      com.tencent.mm.pluginsdk.ui.a.b.a(paramViewGroup.dpY, locala.getUsername());
      switch (locala.status)
      {
      default: 
        switch (locala.ebQ)
        {
        default: 
          localObject = (com.tencent.mm.plugin.account.friend.a.a)getItem(paramInt - 1);
          if (localObject == null) {
            i = -1;
          }
          break;
        }
        break;
      }
    }
    for (;;)
    {
      if (paramInt == 0)
      {
        localObject = a(locala);
        if (bk.bl((String)localObject))
        {
          y.w("MicroMsg.MobileFriendAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { locala.getUsername(), Integer.valueOf(paramInt) });
          paramViewGroup.feg.setVisibility(8);
          return paramView;
          paramViewGroup = (a)paramView.getTag();
          break;
          if (locala.ebQ == 2)
          {
            paramViewGroup.fdZ.setClickable(false);
            paramViewGroup.fdZ.setBackgroundDrawable(null);
            paramViewGroup.eXu.setText(a.i.friend_invited);
            paramViewGroup.eXu.setTextColor(this.context.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.lightgrey));
            break label156;
          }
          paramViewGroup.fdZ.setClickable(true);
          paramViewGroup.fdZ.setBackgroundResource(a.d.btn_solid_green);
          paramViewGroup.eXu.setText(a.i.friend_invite);
          paramViewGroup.eXu.setTextColor(this.context.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.white));
          break label156;
          if ((((j)g.r(j.class)).Fw().abg(locala.getUsername())) || (q.Gj().equals(locala.getUsername())))
          {
            paramViewGroup.fdZ.setClickable(false);
            paramViewGroup.fdZ.setBackgroundDrawable(null);
            paramViewGroup.eXu.setText(a.i.friend_added);
            paramViewGroup.eXu.setTextColor(this.context.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.lightgrey));
            break label156;
          }
          if (locala.ebQ == 2)
          {
            paramViewGroup.fdZ.setClickable(false);
            paramViewGroup.fdZ.setBackgroundDrawable(null);
            paramViewGroup.eXu.setText(a.i.friend_waiting_ask);
            paramViewGroup.eXu.setTextColor(this.context.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.lightgrey));
            break label156;
          }
          paramViewGroup.fdZ.setClickable(true);
          paramViewGroup.fdZ.setBackgroundResource(a.d.btn_solid_green);
          paramViewGroup.eXu.setText(a.i.friend_add);
          paramViewGroup.eXu.setTextColor(this.context.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.white));
          break label156;
          paramViewGroup.eXu.setVisibility(4);
          paramViewGroup.fej.setVisibility(0);
          break label188;
          paramViewGroup.eXu.setVisibility(0);
          paramViewGroup.fej.setVisibility(4);
          break label188;
          i = ((com.tencent.mm.plugin.account.friend.a.a)localObject).fff;
          continue;
        }
        paramViewGroup.feg.setVisibility(0);
        paramViewGroup.feg.setText((CharSequence)localObject);
        paramViewGroup.feg.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        return paramView;
      }
    }
    if (locala.fff != i) {}
    for (int i = 1;; i = 0)
    {
      localObject = a(locala);
      if ((!bk.bl((String)localObject)) && (i != 0)) {
        break;
      }
      y.w("MicroMsg.MobileFriendAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { locala.getUsername(), Integer.valueOf(paramInt) });
      paramViewGroup.feg.setVisibility(8);
      return paramView;
    }
    paramViewGroup.feg.setVisibility(0);
    paramViewGroup.feg.setText((CharSequence)localObject);
    paramViewGroup.feg.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
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
    for (localObject = ((com.tencent.mm.plugin.account.friend.a.b)localObject).dXo.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0 and moblie <> " + str + localStringBuilder.toString() + " order by showhead", null, 0);; localObject = ((com.tencent.mm.plugin.account.friend.a.b)localObject).dXo.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0" + localStringBuilder.toString() + " order by showhead", null, 0))
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
  
  final class a
  {
    String account;
    ImageView dpY;
    TextView eXu;
    int fdX;
    View fdZ;
    TextView feg;
    TextView feh;
    TextView fei;
    ProgressBar fej;
    int status;
    
    public a(View paramView)
    {
      this.feg = ((TextView)paramView.findViewById(a.e.friend_item_catalog));
      this.dpY = ((ImageView)paramView.findViewById(a.e.friend_item_avatar_iv));
      this.feh = ((TextView)paramView.findViewById(a.e.friend_item_nickname));
      this.fei = ((TextView)paramView.findViewById(a.e.friend_item_wx_nickname));
      this.fdZ = paramView.findViewById(a.e.friend_item_action_view);
      this.eXu = ((TextView)paramView.findViewById(a.e.friend_item_status_tv));
      this.fej = ((ProgressBar)paramView.findViewById(a.e.friend_item_status_pb));
      this.fdZ.setOnClickListener(new d.a.1(this, d.this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.d
 * JD-Core Version:    0.7.0.1
 */