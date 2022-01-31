package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.af;
import com.tencent.mm.model.q;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.r;

public final class SelectedMemberChattingRecordUI$a
  extends r<bi>
{
  String drJ;
  String dsu;
  int dsv = -1;
  int dsw = -1;
  private u dsx;
  Context mContext;
  
  public SelectedMemberChattingRecordUI$a(SelectedMemberChattingRecordUI paramSelectedMemberChattingRecordUI, Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    super(paramContext, new bi());
    this.mContext = paramContext;
    this.dsw = paramInt;
    this.drJ = paramString1;
    this.dsu = paramString2;
    this.dsx = ((c)com.tencent.mm.kernel.g.r(c.class)).FF().io(SelectedMemberChattingRecordUI.b(paramSelectedMemberChattingRecordUI));
  }
  
  private static boolean a(CharSequence paramCharSequence, TextView paramTextView)
  {
    if ((paramCharSequence != null) && (paramCharSequence.length() != 0))
    {
      paramTextView.setText(com.tencent.mm.pluginsdk.ui.d.j.b(paramTextView.getContext(), paramCharSequence));
      paramTextView.setVisibility(0);
      return true;
    }
    paramTextView.setVisibility(8);
    return false;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = LayoutInflater.from(this.context).inflate(a.f.member_record_item, null, false);
      paramView = new SelectedMemberChattingRecordUI.b((byte)0);
      paramView.doU = ((ImageView)paramViewGroup.findViewById(a.e.avatar_iv));
      paramView.doV = ((TextView)paramViewGroup.findViewById(a.e.nickname_tv));
      paramView.dsy = ((TextView)paramViewGroup.findViewById(a.e.msg_tv));
      paramView.dsz = ((TextView)paramViewGroup.findViewById(a.e.update_time_tv));
      paramViewGroup.setTag(paramView);
    }
    bi localbi = (bi)getItem(paramInt);
    SelectedMemberChattingRecordUI.b localb = (SelectedMemberChattingRecordUI.b)paramViewGroup.getTag();
    a.b.a(localb.doU, this.dsu);
    paramView = this.dsu;
    Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramView);
    if (!bk.bl(((ao)localObject2).field_conRemark))
    {
      paramView = ((ao)localObject2).field_conRemark;
      if (!bk.bl(paramView)) {
        break label337;
      }
      paramView = ((ad)localObject2).Bp();
    }
    label337:
    for (;;)
    {
      Object localObject1 = paramView;
      if (!a.gR(((ao)localObject2).field_type))
      {
        localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fx().Id(((ao)localObject2).field_username);
        localObject1 = paramView;
        if (localObject2 != null)
        {
          localObject1 = paramView;
          if (!bk.bl(((bv)localObject2).field_conRemark)) {
            localObject1 = ((bv)localObject2).field_conRemark;
          }
        }
      }
      a((CharSequence)localObject1, localb.doV);
      paramView = this.dsu;
      a(SelectedMemberChattingRecordUI.a(ae.getContext(), localbi.getType(), localbi.field_content, paramView, localbi.field_isSend).trim(), localb.dsy);
      a(h.c(this.dst, localbi.field_createTime, true), localb.dsz);
      return paramViewGroup;
      paramView = SelectedMemberChattingRecordUI.a(this.dsx, ((ao)localObject2).field_username);
      break;
    }
  }
  
  public final void yc()
  {
    if ((this.dsv < 0) || (this.dsv > this.dsw)) {
      this.dsv = (this.dsw - 16);
    }
    if ((!bk.bl(SelectedMemberChattingRecordUI.c(this.dst))) && (q.gS(SelectedMemberChattingRecordUI.c(this.dst)))) {
      setCursor(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().bU(this.drJ, this.dsw - this.dsv));
    }
    while (q.gS(SelectedMemberChattingRecordUI.c(this.dst))) {
      return;
    }
    setCursor(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().E(this.drJ, this.dsu, this.dsw - this.dsv));
  }
  
  protected final void yd()
  {
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectedMemberChattingRecordUI.a
 * JD-Core Version:    0.7.0.1
 */