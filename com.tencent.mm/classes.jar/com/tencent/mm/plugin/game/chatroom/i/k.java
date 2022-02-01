package com.tencent.mm.plugin.game.chatroom.i;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.bk;
import com.tencent.mm.autogen.a.bm;
import com.tencent.mm.b.o;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.plugin.game.autogen.chatroom.Channel;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomJumpInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgPack;
import com.tencent.mm.plugin.game.autogen.chatroom.ChosenInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.JumpInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.MsgChannelInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.MsgOptions;
import com.tencent.mm.plugin.game.autogen.chatroom.RoleIcon;
import com.tencent.mm.plugin.game.autogen.chatroom.TagInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.UserRole;
import com.tencent.mm.plugin.game.autogen.chatroom.VoteInfo;
import com.tencent.mm.plugin.game.chatroom.b.b;
import com.tencent.mm.plugin.game.chatroom.b.d;
import com.tencent.mm.plugin.game.chatroom.b.e;
import com.tencent.mm.plugin.game.chatroom.c.q;
import com.tencent.mm.plugin.game.chatroom.c.t;
import com.tencent.mm.plugin.game.chatroom.g.a;
import com.tencent.mm.plugin.game.chatroom.h.e;
import com.tencent.mm.plugin.game.chatroom.h.f;
import com.tencent.mm.plugin.game.chatroom.h.g;
import com.tencent.mm.plugin.game.chatroom.h.h;
import com.tencent.mm.pluginsdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u.f;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.threadpool.i;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class k
  extends RecyclerView.v
{
  private List<Channel> IjD;
  protected int IjE;
  protected long Ijq;
  protected long Ijr;
  private View IlA;
  private ImageView IlB;
  private ImageView IlC;
  private TextView IlD;
  private TextView IlE;
  private View IlF;
  private ImageView IlG;
  private TextView IlH;
  private ViewGroup IlI;
  private ViewGroup IlJ;
  private ViewGroup IlK;
  private MMNeat7extView IlL;
  private ViewGroup IlM;
  private ProgressBar IlN;
  public ImageView IlO;
  private ViewGroup IlP;
  private FrameLayout IlQ;
  private TextView IlR;
  private ImageView IlS;
  private com.tencent.mm.plugin.game.chatroom.b.c IlT;
  public com.tencent.mm.plugin.game.chatroom.b.c IlU;
  public JumpInfo IlV;
  public ChatroomJumpInfo IlW;
  public long IlX;
  private Map<String, b.e> IlY;
  public long IlZ;
  private View Ilu;
  private TextView Ilv;
  private ViewGroup Ilw;
  private int Ilx;
  public ChatroomMsgPack Ily;
  private ViewGroup Ilz;
  public String Ima;
  public long Imb;
  public String lBQ;
  protected Context mContext;
  
  public k(View paramView, int paramInt)
  {
    super(paramView);
    AppMethodBeat.i(275961);
    this.IlX = -1L;
    this.IlY = new HashMap();
    this.IlZ = 0L;
    this.Imb = -1L;
    this.Ilu = paramView.findViewById(h.e.IgE);
    this.Ilv = ((TextView)paramView.findViewById(h.e.HXj));
    this.Ilw = ((ViewGroup)paramView.findViewById(h.e.Igz));
    this.mContext = paramView.getContext();
    this.Ijr = ((Activity)this.mContext).getIntent().getLongExtra("game_report_sourceid", 0L);
    this.Ijq = ((Activity)this.mContext).getIntent().getLongExtra("game_report_ssid", 0L);
    this.Ilx = com.tencent.mm.plugin.game.chatroom.d.Xb(paramInt);
    switch (this.Ilx)
    {
    }
    for (;;)
    {
      hu(this.Ilz);
      AppMethodBeat.o(275961);
      return;
      LayoutInflater.from(this.mContext).inflate(h.f.IhP, this.Ilw, true);
      this.Ilz = ((ViewGroup)paramView.findViewById(h.e.IeT));
      this.IlA = paramView.findViewById(h.e.Ihl);
      this.IlB = ((ImageView)paramView.findViewById(h.e.Ihq));
      this.IlC = ((ImageView)paramView.findViewById(h.e.Ihr));
      this.IlD = ((TextView)paramView.findViewById(h.e.Ihm));
      this.IlE = ((TextView)paramView.findViewById(h.e.Ihv));
      this.IlF = paramView.findViewById(h.e.Iho);
      this.IlG = ((ImageView)paramView.findViewById(h.e.Ihn));
      this.IlH = ((TextView)paramView.findViewById(h.e.Ihp));
      this.IlI = ((ViewGroup)paramView.findViewById(h.e.Ifx));
      this.IlJ = ((ViewGroup)paramView.findViewById(h.e.IgD));
      this.IlK = ((ViewGroup)paramView.findViewById(h.e.IeP));
      this.IlL = ((MMNeat7extView)paramView.findViewById(h.e.IeQ));
      this.IlL.setTextColor(android.graphics.Color.parseColor("#7D90A9"));
      this.IlM = ((ViewGroup)paramView.findViewById(h.e.Igy));
      this.IlN = ((ProgressBar)paramView.findViewById(h.e.IgC));
      this.IlO = ((ImageView)paramView.findViewById(h.e.IgB));
      this.IlP = ((ViewGroup)paramView.findViewById(h.e.IgA));
      this.IlQ = ((FrameLayout)paramView.findViewById(h.e.IfE));
      this.IlR = ((TextView)paramView.findViewById(h.e.IfD));
      this.IlS = ((ImageView)paramView.findViewById(h.e.IfC));
      continue;
      LayoutInflater.from(this.mContext).inflate(h.f.IhS, this.Ilw, true);
      this.Ilz = ((ViewGroup)paramView.findViewById(h.e.IeU));
      continue;
      LayoutInflater.from(this.mContext).inflate(h.f.IhR, this.Ilw, true);
      this.Ilz = ((ViewGroup)paramView.findViewById(h.e.IeS));
    }
  }
  
  private void fCO()
  {
    AppMethodBeat.i(275968);
    GradientDrawable localGradientDrawable = (GradientDrawable)this.Ilz.getBackground();
    if (localGradientDrawable == null)
    {
      AppMethodBeat.o(275968);
      return;
    }
    if ((this.Ily != null) && (this.Ily.msg_options != null) && (this.Ily.msg_options.bg_type == 2))
    {
      localGradientDrawable.setColor(com.tencent.mm.plugin.game.chatroom.e.aFs("#665A33").intValue());
      AppMethodBeat.o(275968);
      return;
    }
    if ((this.Ily != null) && (this.IlU != null) && (Util.nullAsNil(this.Ily.from_username).equals(Util.nullAsNil(this.IlU.getUserName()))))
    {
      localGradientDrawable.setColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.game.chatroom.h.b.BW_100_Alpha_0_1));
      AppMethodBeat.o(275968);
      return;
    }
    localGradientDrawable.setColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.game.chatroom.h.b.UN_BW_0_Alpha_0_3));
    AppMethodBeat.o(275968);
  }
  
  private void hu(final View paramView)
  {
    AppMethodBeat.i(275978);
    if (paramView == null)
    {
      AppMethodBeat.o(275978);
      return;
    }
    com.tencent.mm.ui.widget.b.a local4 = new com.tencent.mm.ui.widget.b.a(paramView.getContext())
    {
      public final boolean fQ(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(275896);
        if ((k.this.fCS()) || (k.this.fCN()))
        {
          AppMethodBeat.o(275896);
          return false;
        }
        if (k.this.Ily != null) {
          com.tencent.mm.game.report.d.mty.a(1L, 27L, k.this.Ijq, k.this.Ijr, k.this.Ily.seq, k.this.Ily.from_username, k.this.IjE);
        }
        if (paramView.getParent() != null) {
          paramView.getParent().requestDisallowInterceptTouchEvent(true);
        }
        boolean bool = super.fQ(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(275896);
        return bool;
      }
      
      public final void onDismiss()
      {
        AppMethodBeat.i(275901);
        if (paramView.getParent() != null) {
          paramView.getParent().requestDisallowInterceptTouchEvent(false);
        }
        super.onDismiss();
        AppMethodBeat.o(275901);
      }
    };
    local4.agjw = true;
    local4.a(paramView, new u.f()new u.i
    {
      public final void OnCreateContextMMMenu(com.tencent.mm.ui.base.s paramAnonymouss, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(275913);
        if ((k.o(k.this) != null) && (k.o(k.this).fCy()) && (k.this.Ily != null))
        {
          if (g.a.Xe(k.this.Ily.channel_id))
          {
            paramAnonymouss.a(9532, k.this.mContext.getString(h.h.IiF), h.g.icons_filled_remove_chosen);
            com.tencent.mm.game.report.d.mty.a(12L, 1L, k.this.Ijq, k.this.Ijr, k.this.Ily.seq, k.this.Ily.from_username, k.this.IjE);
          }
        }
        else
        {
          if ((!g.a.Xd(k.this.IjE)) && (k.this.Ily != null) && (k.this.Ily.seq >= k.p(k.this)))
          {
            paramAnonymouss.a(9533, k.this.mContext.getString(h.h.IiD), h.g.icons_filled_chats);
            com.tencent.mm.game.report.d.mty.a(13L, 1L, k.this.Ijq, k.this.Ijr, k.this.Ily.seq, k.this.Ily.from_username, k.this.IjE);
          }
          if ((k.c(k.this) != null) && (k.c(k.this).fCs()) && (!k.this.fCT()))
          {
            paramAnonymouss.a(9527, k.this.mContext.getString(h.h.IiC), h.g.icons_outlined_at);
            if (k.this.Ily != null) {
              com.tencent.mm.game.report.d.mty.a(5L, 1L, k.this.Ijq, k.this.Ijr, k.this.Ily.seq, k.this.Ily.from_username, k.this.IjE);
            }
          }
          if ((k.this.Ily != null) && (k.this.Ily.msg_options != null) && (k.this.Ily.msg_options.vote_info != null) && (k.this.Ily.msg_options.vote_info.can_vote))
          {
            if (!k.this.Ily.msg_options.vote_info.voted_by_me) {
              break label1009;
            }
            paramAnonymouss.a(9534, k.this.mContext.getString(h.h.IiZ), h.g.icons_filled_game_no_favour_menu);
          }
        }
        for (;;)
        {
          if (k.this.Ily != null) {
            com.tencent.mm.game.report.d.mty.a(15L, 1L, k.this.Ijq, k.this.Ijr, k.this.Ily.seq, k.this.Ily.from_username, k.this.IjE);
          }
          if ((k.this.Ily != null) && (k.this.Ily.msg_options != null) && (!Util.isNullOrNil(k.this.Ily.msg_options.complaint_url)) && (k.o(k.this) != null) && (!Util.nullAsNil(k.o(k.this).getUserName()).equals(k.this.Ily.from_username))) {
            paramAnonymouss.a(9528, k.this.mContext.getString(h.h.app_expose), h.g.icons_filled_report_problem);
          }
          if ((k.this.Ily != null) && (k.o(k.this) != null) && (k.o(k.this).fCy()) && (g.a.Xd(k.this.IjE)))
          {
            paramAnonymouss.a(9530, k.this.mContext.getString(h.h.IiG), h.g.icons_filled_eyes_off);
            if (k.this.Ily != null) {
              com.tencent.mm.game.report.d.mty.a(10L, 1L, k.this.Ijq, k.this.Ijr, k.this.Ily.seq, k.this.Ily.from_username, k.this.IjE);
            }
          }
          if ((k.c(k.this) != null) && (k.c(k.this).fCu()) && (k.o(k.this) != null) && (k.o(k.this).fCt()) && (k.q(k.this) != null) && (k.q(k.this).manage_jump_info != null)) {
            paramAnonymouss.a(9529, k.this.mContext.getString(h.h.IiE), h.g.icons_filled_more2);
          }
          k.this.o(paramAnonymouss);
          AppMethodBeat.o(275913);
          return;
          if ((k.this.Ily.msg_options == null) || (k.this.Ily.msg_options.chosen_info == null) || (!k.this.Ily.msg_options.chosen_info.can_be_chosen)) {
            break;
          }
          paramAnonymouss.a(9531, k.this.mContext.getString(h.h.IiB), h.g.icons_filled_add_chosen);
          com.tencent.mm.game.report.d.mty.a(11L, 1L, k.this.Ijq, k.this.Ijr, k.this.Ily.seq, k.this.Ily.from_username, k.this.IjE);
          break;
          label1009:
          paramAnonymouss.a(9534, k.this.mContext.getString(h.h.Iin), h.g.icons_filled_game_no_favour_menu);
        }
      }
    }, new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(275914);
        switch (paramAnonymousMenuItem.getItemId())
        {
        default: 
          k.this.Xi(paramAnonymousMenuItem.getItemId());
        }
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        AppMethodBeat.o(275914);
                        return;
                      } while ((k.this.Ily == null) || (k.c(k.this) == null));
                      paramAnonymousMenuItem = new bk();
                      paramAnonymousMenuItem.hBw.userName = k.this.Ily.from_username;
                      paramAnonymousMenuItem.hBw.nickName = k.c(k.this).getNickName();
                      paramAnonymousMenuItem.publish();
                      com.tencent.mm.game.report.d.mty.a(5L, 2L, k.this.Ijq, k.this.Ijr, k.this.Ily.seq, k.this.Ily.from_username, k.this.IjE);
                      AppMethodBeat.o(275914);
                      return;
                    } while (k.this.Ily == null);
                    paramAnonymousMenuItem = new Intent();
                    paramAnonymousMenuItem.putExtra("rawUrl", k.this.Ily.msg_options.complaint_url);
                    com.tencent.mm.br.c.b(k.this.mContext, "webview", ".ui.tools.WebViewUI", paramAnonymousMenuItem);
                    AppMethodBeat.o(275914);
                    return;
                  } while (k.this.Ily == null);
                  k.a(k.this, k.this.Ily.seq);
                  AppMethodBeat.o(275914);
                  return;
                } while ((k.c(k.this) == null) || (k.o(k.this) == null) || (k.q(k.this) == null) || (k.q(k.this).manage_jump_info == null));
                paramAnonymousMenuItem = k.q(k.this).manage_jump_info.jump_url;
                Object localObject;
                if (!Util.isNullOrNil(paramAnonymousMenuItem))
                {
                  localObject = com.tencent.mm.plugin.game.chatroom.e.iO(paramAnonymousMenuItem, "username=" + k.c(k.this).getUserName());
                  paramAnonymousMenuItem = (MenuItem)localObject;
                  if (k.o(k.this).fCr() != null) {
                    paramAnonymousMenuItem = com.tencent.mm.plugin.game.chatroom.e.iO((String)localObject, "from_role=" + k.o(k.this).fCr().role);
                  }
                  localObject = paramAnonymousMenuItem;
                  if (k.c(k.this).fCr() != null) {
                    localObject = com.tencent.mm.plugin.game.chatroom.e.iO(paramAnonymousMenuItem, "to_role=" + k.c(k.this).fCr().role);
                  }
                  paramAnonymousMenuItem = com.tencent.mm.plugin.game.chatroom.e.iO((String)localObject, "chatroom_name=" + k.n(k.this));
                  localObject = new JumpInfo();
                }
                try
                {
                  ((JumpInfo)localObject).parseFrom(k.q(k.this).manage_jump_info.toByteArray());
                  ((JumpInfo)localObject).jump_url = paramAnonymousMenuItem;
                  com.tencent.mm.plugin.game.chatroom.e.a(k.this.mContext, (JumpInfo)localObject, 0, null);
                  AppMethodBeat.o(275914);
                  return;
                }
                catch (IOException paramAnonymousMenuItem)
                {
                  AppMethodBeat.o(275914);
                  return;
                }
              } while (k.this.Ily == null);
              k.a(k.this, k.this.Ily.seq, true);
              AppMethodBeat.o(275914);
              return;
            } while (k.this.Ily == null);
            k.a(k.this, k.this.Ily.seq, false);
            AppMethodBeat.o(275914);
            return;
          } while (k.this.Ily == null);
          paramAnonymousMenuItem = new bm();
          paramAnonymousMenuItem.hBz.channelId = g.a.Ieu;
          paramAnonymousMenuItem.hBz.seq = k.this.Ily.seq;
          paramAnonymousMenuItem.hBz.highlight = true;
          paramAnonymousMenuItem.publish();
          com.tencent.mm.game.report.d.mty.a(13L, 2L, k.this.Ijq, k.this.Ijr, k.this.Ily.seq, k.this.Ily.from_username, k.this.IjE);
          AppMethodBeat.o(275914);
          return;
        } while ((k.this.Ily == null) || (k.this.Ily.msg_options == null) || (k.this.Ily.msg_options.vote_info == null) || (!k.this.Ily.msg_options.vote_info.can_vote));
        if (k.this.Ily.msg_options.vote_info.voted_by_me) {}
        for (paramAnonymousMenuItem = new t(k.n(k.this), k.this.Ily.seq, false, k.this.Ily.from_username, 15);; paramAnonymousMenuItem = new t(k.n(k.this), k.this.Ily.seq, true, k.this.Ily.from_username, 15))
        {
          com.tencent.mm.kernel.h.aZW().a(paramAnonymousMenuItem, 0);
          AppMethodBeat.o(275914);
          return;
        }
      }
    });
    AppMethodBeat.o(275978);
  }
  
  private void je(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(275981);
    JSONObject localJSONObject;
    if (this.Ily != null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("lightup", fCU());
      label33:
      d.a locala = com.tencent.mm.game.report.d.mty;
      d.a.a(paramInt1, 2L, this.Ijq, this.Ijr, this.Ily.seq, this.Ily.from_username, paramInt2, this.IjE, localJSONObject.toString());
      AppMethodBeat.o(275981);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label33;
    }
  }
  
  protected View K(ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public final void M(int paramInt, List<Channel> paramList)
  {
    this.IjE = paramInt;
    this.IjD = paramList;
  }
  
  protected void Xi(int paramInt) {}
  
  protected void a(ChatroomMsgPack paramChatroomMsgPack) {}
  
  public final void a(final ChatroomMsgPack paramChatroomMsgPack, long paramLong, b.b paramb, Set<Long> paramSet)
  {
    AppMethodBeat.i(276129);
    if ((paramChatroomMsgPack == null) || (Util.isNullOrNil(paramChatroomMsgPack.from_username)))
    {
      AppMethodBeat.o(276129);
      return;
    }
    if ((paramb.IdW == -1L) && (paramb.IdX == -1L))
    {
      long l = paramChatroomMsgPack.seq;
      paramb.IdX = l;
      paramb.IdW = l;
      l = paramChatroomMsgPack.send_time;
      paramb.IdY = l;
      paramb.eRP = l;
    }
    int i = 0;
    label158:
    int j;
    label196:
    int k;
    if (!paramSet.contains(Long.valueOf(paramChatroomMsgPack.seq)))
    {
      if (paramChatroomMsgPack.send_time - paramLong > 300L)
      {
        i = 1;
        this.Ilv.setVisibility(0);
        this.Ilv.setText(f.d(this.mContext, paramChatroomMsgPack.send_time * 1000L, false));
        if (i != 0) {
          break label1430;
        }
        if ((paramChatroomMsgPack.seq <= paramb.IdX) || (paramChatroomMsgPack.send_time - paramb.IdY < 1200L)) {
          break label399;
        }
        j = 1;
        if ((paramChatroomMsgPack.seq >= paramb.IdW) || (paramb.eRP - paramChatroomMsgPack.send_time < 1200L)) {
          break label405;
        }
        k = 1;
        label229:
        if ((j == 0) && (k == 0)) {
          break label1430;
        }
      }
    }
    else
    {
      i = 1;
      this.Ilv.setVisibility(0);
      this.Ilv.setText(f.d(this.mContext, paramChatroomMsgPack.send_time * 1000L, false));
    }
    label399:
    label405:
    label1430:
    for (;;)
    {
      if (i != 0)
      {
        if (paramChatroomMsgPack.seq > paramb.IdX)
        {
          paramb.IdX = paramChatroomMsgPack.seq;
          paramb.IdY = paramChatroomMsgPack.send_time;
          label309:
          paramSet.add(Long.valueOf(paramChatroomMsgPack.seq));
        }
      }
      else
      {
        if (paramChatroomMsgPack.seq != this.IlZ) {
          break label445;
        }
        this.Ilu.setVisibility(0);
      }
      for (;;)
      {
        this.Ily = paramChatroomMsgPack;
        switch (this.Ilx)
        {
        default: 
          AppMethodBeat.o(276129);
          return;
          this.Ilv.setVisibility(8);
          break label158;
          j = 0;
          break label196;
          k = 0;
          break label229;
          if (paramChatroomMsgPack.seq >= paramb.IdW) {
            break label309;
          }
          paramb.IdW = paramChatroomMsgPack.seq;
          paramb.eRP = paramChatroomMsgPack.send_time;
          break label309;
          label445:
          this.Ilu.setVisibility(8);
        }
      }
      paramChatroomMsgPack = this.IlV;
      com.tencent.mm.ui.i.a.a.g(this.IlB, this.Ily.from_username);
      this.IlB.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(275980);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/piece/GameChatItemVH$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
          if ((k.c(k.this) != null) && (!k.this.fCS()) && (!k.this.fCT()))
          {
            paramAnonymousView = new bk();
            paramAnonymousView.hBw.userName = k.this.Ily.from_username;
            paramAnonymousView.hBw.nickName = k.c(k.this).getNickName();
            paramAnonymousView.publish();
            com.tencent.mm.game.report.d.mty.a(4L, 27L, k.this.Ijq, k.this.Ijr, k.this.Ily.seq, k.this.Ily.from_username, k.this.IjE);
          }
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/game/chatroom/piece/GameChatItemVH$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(275980);
          return true;
        }
      });
      this.IlB.setOnClickListener(new View.OnClickListener()
      {
        /* Error */
        public final void onClick(View paramAnonymousView)
        {
          // Byte code:
          //   0: aload_0
          //   1: monitorenter
          //   2: ldc 27
          //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   7: new 35	com/tencent/mm/hellhoundlib/b/b
          //   10: dup
          //   11: invokespecial 36	com/tencent/mm/hellhoundlib/b/b:<init>	()V
          //   14: astore_2
          //   15: aload_2
          //   16: aload_1
          //   17: invokevirtual 40	com/tencent/mm/hellhoundlib/b/b:cH	(Ljava/lang/Object;)V
          //   20: ldc 42
          //   22: ldc 43
          //   24: ldc 44
          //   26: ldc 45
          //   28: aload_0
          //   29: aload_2
          //   30: invokevirtual 49	com/tencent/mm/hellhoundlib/b/b:aYj	()[Ljava/lang/Object;
          //   33: invokestatic 55	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V
          //   36: aload_0
          //   37: getfield 18	com/tencent/mm/plugin/game/chatroom/i/k$14:Imc	Lcom/tencent/mm/plugin/game/chatroom/i/k;
          //   40: invokestatic 58	com/tencent/mm/plugin/game/chatroom/i/k:c	(Lcom/tencent/mm/plugin/game/chatroom/i/k;)Lcom/tencent/mm/plugin/game/chatroom/b/c;
          //   43: ifnull +169 -> 212
          //   46: aload_0
          //   47: getfield 18	com/tencent/mm/plugin/game/chatroom/i/k$14:Imc	Lcom/tencent/mm/plugin/game/chatroom/i/k;
          //   50: invokevirtual 62	com/tencent/mm/plugin/game/chatroom/i/k:fCS	()Z
          //   53: ifne +159 -> 212
          //   56: aload_0
          //   57: getfield 18	com/tencent/mm/plugin/game/chatroom/i/k$14:Imc	Lcom/tencent/mm/plugin/game/chatroom/i/k;
          //   60: invokestatic 58	com/tencent/mm/plugin/game/chatroom/i/k:c	(Lcom/tencent/mm/plugin/game/chatroom/i/k;)Lcom/tencent/mm/plugin/game/chatroom/b/c;
          //   63: invokeinterface 68 1 0
          //   68: ifnull +164 -> 232
          //   71: aload_0
          //   72: getfield 18	com/tencent/mm/plugin/game/chatroom/i/k$14:Imc	Lcom/tencent/mm/plugin/game/chatroom/i/k;
          //   75: invokestatic 58	com/tencent/mm/plugin/game/chatroom/i/k:c	(Lcom/tencent/mm/plugin/game/chatroom/i/k;)Lcom/tencent/mm/plugin/game/chatroom/b/c;
          //   78: invokeinterface 68 1 0
          //   83: getfield 74	com/tencent/mm/plugin/game/autogen/chatroom/JumpInfo:jump_type	I
          //   86: iconst_1
          //   87: if_icmpne +145 -> 232
          //   90: aload_0
          //   91: getfield 20	com/tencent/mm/plugin/game/chatroom/i/k$14:Imi	Lcom/tencent/mm/plugin/game/autogen/chatroom/JumpInfo;
          //   94: ifnull +138 -> 232
          //   97: aload_0
          //   98: getfield 20	com/tencent/mm/plugin/game/chatroom/i/k$14:Imi	Lcom/tencent/mm/plugin/game/autogen/chatroom/JumpInfo;
          //   101: getfield 78	com/tencent/mm/plugin/game/autogen/chatroom/JumpInfo:jump_url	Ljava/lang/String;
          //   104: invokestatic 84	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
          //   107: ifne +125 -> 232
          //   110: aload_0
          //   111: getfield 20	com/tencent/mm/plugin/game/chatroom/i/k$14:Imi	Lcom/tencent/mm/plugin/game/autogen/chatroom/JumpInfo;
          //   114: getfield 87	com/tencent/mm/plugin/game/autogen/chatroom/JumpInfo:preload_id	Ljava/lang/String;
          //   117: invokestatic 91	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
          //   120: aload_0
          //   121: getfield 18	com/tencent/mm/plugin/game/chatroom/i/k$14:Imc	Lcom/tencent/mm/plugin/game/chatroom/i/k;
          //   124: invokestatic 58	com/tencent/mm/plugin/game/chatroom/i/k:c	(Lcom/tencent/mm/plugin/game/chatroom/i/k;)Lcom/tencent/mm/plugin/game/chatroom/b/c;
          //   127: invokeinterface 68 1 0
          //   132: getfield 87	com/tencent/mm/plugin/game/autogen/chatroom/JumpInfo:preload_id	Ljava/lang/String;
          //   135: invokevirtual 97	java/lang/String:equals	(Ljava/lang/Object;)Z
          //   138: ifeq +94 -> 232
          //   141: aload_0
          //   142: getfield 20	com/tencent/mm/plugin/game/chatroom/i/k$14:Imi	Lcom/tencent/mm/plugin/game/autogen/chatroom/JumpInfo;
          //   145: getfield 78	com/tencent/mm/plugin/game/autogen/chatroom/JumpInfo:jump_url	Ljava/lang/String;
          //   148: new 10	com/tencent/mm/plugin/game/chatroom/i/k$14$1
          //   151: dup
          //   152: aload_0
          //   153: invokespecial 100	com/tencent/mm/plugin/game/chatroom/i/k$14$1:<init>	(Lcom/tencent/mm/plugin/game/chatroom/i/k$14;)V
          //   156: invokestatic 106	com/tencent/mm/plugin/game/luggage/h:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/game/luggage/h$b;)V
          //   159: getstatic 112	com/tencent/mm/game/report/d:mty	Lcom/tencent/mm/game/report/d$a;
          //   162: ldc2_w 113
          //   165: ldc2_w 115
          //   168: aload_0
          //   169: getfield 18	com/tencent/mm/plugin/game/chatroom/i/k$14:Imc	Lcom/tencent/mm/plugin/game/chatroom/i/k;
          //   172: getfield 120	com/tencent/mm/plugin/game/chatroom/i/k:Ijq	J
          //   175: aload_0
          //   176: getfield 18	com/tencent/mm/plugin/game/chatroom/i/k$14:Imc	Lcom/tencent/mm/plugin/game/chatroom/i/k;
          //   179: getfield 123	com/tencent/mm/plugin/game/chatroom/i/k:Ijr	J
          //   182: aload_0
          //   183: getfield 18	com/tencent/mm/plugin/game/chatroom/i/k$14:Imc	Lcom/tencent/mm/plugin/game/chatroom/i/k;
          //   186: getfield 127	com/tencent/mm/plugin/game/chatroom/i/k:Ily	Lcom/tencent/mm/plugin/game/autogen/chatroom/ChatroomMsgPack;
          //   189: getfield 132	com/tencent/mm/plugin/game/autogen/chatroom/ChatroomMsgPack:seq	J
          //   192: aload_0
          //   193: getfield 18	com/tencent/mm/plugin/game/chatroom/i/k$14:Imc	Lcom/tencent/mm/plugin/game/chatroom/i/k;
          //   196: getfield 127	com/tencent/mm/plugin/game/chatroom/i/k:Ily	Lcom/tencent/mm/plugin/game/autogen/chatroom/ChatroomMsgPack;
          //   199: getfield 135	com/tencent/mm/plugin/game/autogen/chatroom/ChatroomMsgPack:from_username	Ljava/lang/String;
          //   202: aload_0
          //   203: getfield 18	com/tencent/mm/plugin/game/chatroom/i/k$14:Imc	Lcom/tencent/mm/plugin/game/chatroom/i/k;
          //   206: getfield 138	com/tencent/mm/plugin/game/chatroom/i/k:IjE	I
          //   209: invokevirtual 143	com/tencent/mm/game/report/d$a:a	(JJJJJLjava/lang/String;I)V
          //   212: aload_0
          //   213: ldc 42
          //   215: ldc 43
          //   217: ldc 44
          //   219: ldc 45
          //   221: invokestatic 146	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
          //   224: ldc 27
          //   226: invokestatic 149	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   229: aload_0
          //   230: monitorexit
          //   231: return
          //   232: aload_0
          //   233: getfield 18	com/tencent/mm/plugin/game/chatroom/i/k$14:Imc	Lcom/tencent/mm/plugin/game/chatroom/i/k;
          //   236: getfield 153	com/tencent/mm/plugin/game/chatroom/i/k:mContext	Landroid/content/Context;
          //   239: aload_0
          //   240: getfield 18	com/tencent/mm/plugin/game/chatroom/i/k$14:Imc	Lcom/tencent/mm/plugin/game/chatroom/i/k;
          //   243: invokestatic 58	com/tencent/mm/plugin/game/chatroom/i/k:c	(Lcom/tencent/mm/plugin/game/chatroom/i/k;)Lcom/tencent/mm/plugin/game/chatroom/b/c;
          //   246: invokeinterface 68 1 0
          //   251: iconst_0
          //   252: aconst_null
          //   253: invokestatic 158	com/tencent/mm/plugin/game/chatroom/e:a	(Landroid/content/Context;Lcom/tencent/mm/plugin/game/autogen/chatroom/JumpInfo;ILjava/lang/String;)I
          //   256: pop
          //   257: aload_0
          //   258: getfield 18	com/tencent/mm/plugin/game/chatroom/i/k$14:Imc	Lcom/tencent/mm/plugin/game/chatroom/i/k;
          //   261: invokestatic 58	com/tencent/mm/plugin/game/chatroom/i/k:c	(Lcom/tencent/mm/plugin/game/chatroom/i/k;)Lcom/tencent/mm/plugin/game/chatroom/b/c;
          //   264: invokeinterface 68 1 0
          //   269: ifnull -110 -> 159
          //   272: ldc 160
          //   274: ldc 162
          //   276: iconst_1
          //   277: anewarray 4	java/lang/Object
          //   280: dup
          //   281: iconst_0
          //   282: aload_0
          //   283: getfield 18	com/tencent/mm/plugin/game/chatroom/i/k$14:Imc	Lcom/tencent/mm/plugin/game/chatroom/i/k;
          //   286: invokestatic 58	com/tencent/mm/plugin/game/chatroom/i/k:c	(Lcom/tencent/mm/plugin/game/chatroom/i/k;)Lcom/tencent/mm/plugin/game/chatroom/b/c;
          //   289: invokeinterface 68 1 0
          //   294: getfield 78	com/tencent/mm/plugin/game/autogen/chatroom/JumpInfo:jump_url	Ljava/lang/String;
          //   297: aastore
          //   298: invokestatic 167	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   301: goto -142 -> 159
          //   304: astore_1
          //   305: aload_0
          //   306: monitorexit
          //   307: aload_1
          //   308: athrow
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	309	0	this	14
          //   0	309	1	paramAnonymousView	View
          //   14	16	2	localb	com.tencent.mm.hellhoundlib.b.b
          // Exception table:
          //   from	to	target	type
          //   2	159	304	finally
          //   159	212	304	finally
          //   212	229	304	finally
          //   232	301	304	finally
        }
      });
      fCR();
      ((com.tencent.mm.plugin.game.chatroom.b.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.chatroom.b.b.class)).a(this.Ily.from_username, new com.tencent.mm.plugin.game.chatroom.b.b.a()
      {
        public final void onDone(final Map<String, com.tencent.mm.plugin.game.chatroom.b.c> paramAnonymousMap)
        {
          AppMethodBeat.i(275958);
          if ((paramAnonymousMap != null) && (paramAnonymousMap.containsKey(k.this.Ily.from_username)))
          {
            paramAnonymousMap = (com.tencent.mm.plugin.game.chatroom.b.c)paramAnonymousMap.get(k.this.Ily.from_username);
            k.a(k.this, paramAnonymousMap);
            k.f(k.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(275907);
                k.e(k.this).setContentDescription(paramAnonymousMap.getNickName());
                k.f(k.this).setText(com.tencent.mm.pluginsdk.ui.span.p.b(k.this.mContext, paramAnonymousMap.getNickName()));
                Object localObject1 = paramAnonymousMap.fCq();
                Object localObject2;
                if ((localObject1 != null) && (!Util.isNullOrNil(((TagInfo)localObject1).desc)))
                {
                  k.g(k.this).setVisibility(0);
                  localObject2 = k.this.mContext.getString(h.h.IiV, new Object[] { ((TagInfo)localObject1).desc });
                  k.g(k.this).setText(com.tencent.mm.pluginsdk.ui.span.p.b(k.this.mContext, (CharSequence)localObject2));
                  localObject1 = ((TagInfo)localObject1).color;
                  if (localObject1 != null)
                  {
                    localObject1 = com.tencent.mm.plugin.game.chatroom.e.aFs(Util.nullAsNil(((com.tencent.mm.plugin.game.autogen.chatroom.Color)localObject1).dark_color));
                    if (localObject1 != null) {
                      k.g(k.this).setTextColor(((Integer)localObject1).intValue());
                    }
                  }
                  localObject1 = paramAnonymousMap.fCr();
                  if ((localObject1 == null) || (((UserRole)localObject1).role_icon == null)) {
                    break label454;
                  }
                  k.h(k.this).setVisibility(0);
                  com.tencent.mm.plugin.game.d.e.fIb().p(k.h(k.this), ((UserRole)localObject1).role_icon.icon_url);
                  i = 1;
                  label256:
                  if ((localObject1 == null) || (Util.isNullOrNil(((UserRole)localObject1).desc))) {
                    break label474;
                  }
                  k.i(k.this).setVisibility(0);
                  k.i(k.this).setText(((UserRole)localObject1).desc);
                  localObject2 = com.tencent.mm.plugin.game.chatroom.e.aFs(Util.nullAsNil(((UserRole)localObject1).word_color));
                  if (localObject2 != null) {
                    k.i(k.this).setTextColor(((Integer)localObject2).intValue());
                  }
                  i = 1;
                  label335:
                  if (i != 0)
                  {
                    localObject2 = com.tencent.mm.plugin.game.chatroom.e.aFs(Util.nullAsNil(((UserRole)localObject1).background_color));
                    if (localObject2 != null)
                    {
                      GradientDrawable localGradientDrawable = (GradientDrawable)k.j(k.this).getBackground();
                      if (localGradientDrawable != null) {
                        localGradientDrawable.setColor(((Integer)localObject2).intValue());
                      }
                    }
                  }
                  localObject2 = k.j(k.this);
                  if (i == 0) {
                    break label492;
                  }
                }
                label454:
                label474:
                label492:
                for (int i = 0;; i = 8)
                {
                  ((View)localObject2).setVisibility(i);
                  k.j(k.this).setOnClickListener(new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymous3View)
                    {
                      AppMethodBeat.i(275915);
                      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                      ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymous3View);
                      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/piece/GameChatItemVH$5$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
                      if ((this.Imm != null) && (this.Imm.role_icon != null))
                      {
                        com.tencent.mm.plugin.game.chatroom.e.a(k.this.mContext, this.Imm.role_icon.jump_info, 0, null);
                        if (k.this.Ily != null) {
                          paramAnonymous3View = new JSONObject();
                        }
                      }
                      try
                      {
                        paramAnonymous3View.put("role", this.Imm.role);
                        label118:
                        localObject = com.tencent.mm.game.report.d.mty;
                        d.a.a(21L, 2L, k.this.Ijq, k.this.Ijr, k.this.Ily.seq, k.this.Ily.from_username, 0L, k.this.IjE, paramAnonymous3View.toString());
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/piece/GameChatItemVH$5$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(275915);
                        return;
                      }
                      catch (JSONException localJSONException)
                      {
                        break label118;
                      }
                    }
                  });
                  AppMethodBeat.o(275907);
                  return;
                  k.g(k.this).setVisibility(8);
                  break;
                  k.h(k.this).setVisibility(8);
                  i = 0;
                  break label256;
                  k.i(k.this).setVisibility(8);
                  break label335;
                }
              }
            });
          }
          AppMethodBeat.o(275958);
        }
      });
      paramChatroomMsgPack = null;
      switch (com.tencent.mm.plugin.game.chatroom.d.jc(this.Ily.msg_type, this.Ily.msg_sub_type))
      {
      default: 
        paramb = K(paramChatroomMsgPack);
        if ((paramChatroomMsgPack != null) && (paramb != null))
        {
          paramChatroomMsgPack.removeAllViews();
          paramChatroomMsgPack.addView(paramb);
          a(this.Ily);
          paramb.setOnClickListener(new k.16(this));
          hu(paramb);
        }
        this.IlN.setVisibility(8);
        this.IlO.setVisibility(8);
        if ((this.Ily.msg_options != null) && (this.Ily.msg_options.cli_local_data != null))
        {
          i = (int)(o.Z(this.Ily.msg_options.cli_local_data.toByteArray()) & 0xF);
          if (i == 1) {
            this.IlN.setVisibility(0);
          }
        }
        else
        {
          label763:
          this.IlO.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(275971);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/piece/GameChatItemVH$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              if ((k.k(k.this).getTag() instanceof b.d))
              {
                paramAnonymousView = (b.d)k.k(k.this).getTag();
                Log.i("GameChatRoom.GameChatItemVH", "retry send msg, cliMsgId:%s", new Object[] { paramAnonymousView.Ied });
                k.k(k.this).setVisibility(8);
                k.l(k.this).setVisibility(0);
                paramAnonymousView = new com.tencent.mm.plugin.game.chatroom.c.p(paramAnonymousView);
                com.tencent.mm.kernel.h.aZW().a(paramAnonymousView, 0);
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/piece/GameChatItemVH$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(275971);
            }
          });
          if (this.IlK != null)
          {
            boolean bool2 = false;
            boolean bool1 = bool2;
            if (this.Ily != null)
            {
              bool1 = bool2;
              if (this.Ily.msg_options != null)
              {
                bool1 = bool2;
                if (this.Ily.msg_options.msg_channel_info != null) {
                  bool1 = this.Ily.msg_options.msg_channel_info.show_channel_info;
                }
              }
            }
            if ((!bool1) || (this.Ily == null) || (Util.isNullOrNil(this.IjD))) {
              break label1367;
            }
            paramb = this.IjD.iterator();
            do
            {
              if (!paramb.hasNext()) {
                break;
              }
              paramChatroomMsgPack = (Channel)paramb.next();
            } while (paramChatroomMsgPack.channel_id != this.Ily.channel_id);
          }
        }
        break;
      }
      for (;;)
      {
        if ((paramChatroomMsgPack == null) || (Util.isNullOrNil(paramChatroomMsgPack.name)) || (g.a.Xd(paramChatroomMsgPack.channel_id)))
        {
          this.IlK.setVisibility(8);
          label946:
          if (this.Ily.msg_options != null) {
            break label1379;
          }
        }
        label1367:
        label1379:
        for (paramChatroomMsgPack = null;; paramChatroomMsgPack = this.Ily.msg_options.vote_info)
        {
          a(paramChatroomMsgPack);
          AppMethodBeat.o(276129);
          return;
          paramChatroomMsgPack = (RelativeLayout.LayoutParams)this.IlI.getLayoutParams();
          paramChatroomMsgPack.addRule(3, h.e.Ihl);
          paramChatroomMsgPack.addRule(5, h.e.Ihl);
          paramChatroomMsgPack.rightMargin = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 16);
          this.IlI.setLayoutParams(paramChatroomMsgPack);
          this.IlJ.setVisibility(0);
          this.IlM.setVisibility(8);
          paramChatroomMsgPack = (RelativeLayout.LayoutParams)this.IlA.getLayoutParams();
          paramChatroomMsgPack.addRule(6, h.e.Ihq);
          this.IlA.setLayoutParams(paramChatroomMsgPack);
          paramChatroomMsgPack = this.IlJ;
          break;
          paramChatroomMsgPack = (RelativeLayout.LayoutParams)this.IlI.getLayoutParams();
          paramChatroomMsgPack.addRule(3, h.e.Ihq);
          paramChatroomMsgPack.removeRule(5);
          this.IlI.setLayoutParams(paramChatroomMsgPack);
          this.IlJ.setVisibility(8);
          this.IlM.setVisibility(0);
          this.IlA.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(275963);
              RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)k.m(k.this).getLayoutParams();
              localLayoutParams.topMargin = (k.e(k.this).getTop() + (k.e(k.this).getHeight() - k.m(k.this).getHeight()) / 2);
              k.m(k.this).setLayoutParams(localLayoutParams);
              AppMethodBeat.o(275963);
            }
          });
          paramChatroomMsgPack = (FrameLayout.LayoutParams)this.IlM.getLayoutParams();
          paramChatroomMsgPack.bottomMargin = 0;
          this.IlM.setLayoutParams(paramChatroomMsgPack);
          paramChatroomMsgPack = this.IlM;
          break;
          paramChatroomMsgPack = (RelativeLayout.LayoutParams)this.IlI.getLayoutParams();
          paramChatroomMsgPack.addRule(3, h.e.Ihq);
          paramChatroomMsgPack.removeRule(5);
          paramChatroomMsgPack.leftMargin = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 16);
          paramChatroomMsgPack.rightMargin = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 16);
          this.IlI.setLayoutParams(paramChatroomMsgPack);
          this.IlJ.setVisibility(8);
          this.IlM.setVisibility(0);
          this.IlA.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(275945);
              RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)k.m(k.this).getLayoutParams();
              localLayoutParams.topMargin = (k.e(k.this).getTop() + (k.e(k.this).getHeight() - k.m(k.this).getHeight()) / 2);
              k.m(k.this).setLayoutParams(localLayoutParams);
              AppMethodBeat.o(275945);
            }
          });
          paramChatroomMsgPack = (FrameLayout.LayoutParams)this.IlM.getLayoutParams();
          paramChatroomMsgPack.bottomMargin = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 8);
          this.IlM.setLayoutParams(paramChatroomMsgPack);
          paramChatroomMsgPack = this.IlM;
          break;
          if (i != 2) {
            break label763;
          }
          this.IlO.setVisibility(0);
          break label763;
          this.IlK.setVisibility(0);
          this.IlL.setTag(Integer.valueOf(paramChatroomMsgPack.channel_id));
          this.IlL.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(275900);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/piece/GameChatItemVH$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              if ((paramAnonymousView != null) && ((paramAnonymousView.getTag() instanceof Integer)))
              {
                int i = ((Integer)paramAnonymousView.getTag()).intValue();
                if (i == k.this.IjE)
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/piece/GameChatItemVH$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(275900);
                  return;
                }
                paramAnonymousView = new bm();
                paramAnonymousView.hBz.channelId = i;
                paramAnonymousView.hBz.hBA = true;
                paramAnonymousView.publish();
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/piece/GameChatItemVH$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(275900);
            }
          });
          this.IlL.aZ(paramChatroomMsgPack.name);
          break label946;
          this.IlK.setVisibility(8);
          break label946;
        }
        ((com.tencent.mm.plugin.game.chatroom.b.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.chatroom.b.b.class)).a(this.Ily.from_username, new com.tencent.mm.plugin.game.chatroom.b.b.a()
        {
          public final void onDone(final Map<String, com.tencent.mm.plugin.game.chatroom.b.c> paramAnonymousMap)
          {
            AppMethodBeat.i(275903);
            k.a(k.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(275985);
                if ((paramAnonymousMap != null) && (paramAnonymousMap.containsKey(k.this.Ily.from_username)))
                {
                  localObject = (com.tencent.mm.plugin.game.chatroom.b.c)paramAnonymousMap.get(k.this.Ily.from_username);
                  k.a(k.this, (com.tencent.mm.plugin.game.chatroom.b.c)localObject);
                }
                Object localObject = k.this.K(k.a(k.this));
                if ((k.a(k.this) != null) && (localObject != null))
                {
                  k.a(k.this).removeAllViews();
                  k.a(k.this).addView((View)localObject);
                  k.this.a(k.this.Ily);
                  ((View)localObject).setOnClickListener(new k.1.1.1(this));
                  k.a(k.this, (View)localObject);
                }
                AppMethodBeat.o(275985);
              }
            });
            AppMethodBeat.o(275903);
          }
        });
        break;
        paramChatroomMsgPack = null;
      }
    }
  }
  
  public final void a(VoteInfo paramVoteInfo)
  {
    AppMethodBeat.i(276218);
    if ((paramVoteInfo != null) && (paramVoteInfo.show_type == 2))
    {
      this.IlP.setVisibility(0);
      if (Util.isNullOrNil(paramVoteInfo.latest_voter_username_list))
      {
        this.IlQ.setVisibility(8);
        if (!paramVoteInfo.voted_by_me) {
          break label253;
        }
        this.IlR.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.game.chatroom.h.b.UN_Yellow_90));
        this.IlS.setVisibility(0);
        this.IlS.setImageResource(h.g.icons_filled_game_favour);
      }
      for (;;)
      {
        this.IlS.setTag(paramVoteInfo);
        this.IlR.setText(paramVoteInfo.desc);
        this.IlS.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(275898);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/piece/GameChatItemVH$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (((paramAnonymousView.getTag() instanceof VoteInfo)) && (((VoteInfo)paramAnonymousView.getTag()).can_vote)) {
              if (!((VoteInfo)paramAnonymousView.getTag()).voted_by_me) {
                break label135;
              }
            }
            label135:
            for (paramAnonymousView = new t(k.n(k.this), k.this.Ily.seq, false, k.this.Ily.from_username, 16);; paramAnonymousView = new t(k.n(k.this), k.this.Ily.seq, true, k.this.Ily.from_username, 16))
            {
              com.tencent.mm.kernel.h.aZW().a(paramAnonymousView, 0);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/piece/GameChatItemVH$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(275898);
              return;
            }
          }
        });
        AppMethodBeat.o(276218);
        return;
        this.IlQ.setVisibility(0);
        this.IlQ.removeAllViews();
        int i = 0;
        while (i < paramVoteInfo.latest_voter_username_list.size())
        {
          Object localObject = (String)paramVoteInfo.latest_voter_username_list.get(i);
          View localView = LayoutInflater.from(this.mContext).inflate(h.f.IhJ, this.IlQ, false);
          com.tencent.mm.ui.i.a.a.g((ImageView)localView.findViewById(h.e.IfF), (String)localObject);
          localObject = new FrameLayout.LayoutParams(-2, -2);
          ((FrameLayout.LayoutParams)localObject).leftMargin = (com.tencent.mm.cd.a.fromDPToPix(this.mContext, 12) * i);
          this.IlQ.addView(localView, 0, (ViewGroup.LayoutParams)localObject);
          i += 1;
        }
        break;
        label253:
        this.IlR.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.game.chatroom.h.b.BW_100_Alpha_0_3));
        this.IlS.setVisibility(0);
        this.IlS.setImageResource(h.g.icons_filled_game_no_favour);
      }
    }
    this.IlP.setVisibility(8);
    AppMethodBeat.o(276218);
  }
  
  public final void aq(Map<String, b.e> paramMap)
  {
    AppMethodBeat.i(276158);
    if (paramMap != null)
    {
      this.IlY.clear();
      this.IlY.putAll(paramMap);
    }
    AppMethodBeat.o(276158);
  }
  
  protected void fCM() {}
  
  protected boolean fCN()
  {
    return false;
  }
  
  public final void fCP()
  {
    AppMethodBeat.i(276145);
    if ((this.Ily == null) || (this.Ily.seq != this.IlX))
    {
      AppMethodBeat.o(276145);
      return;
    }
    GradientDrawable localGradientDrawable = (GradientDrawable)this.Ilz.getBackground();
    if (localGradientDrawable == null)
    {
      AppMethodBeat.o(276145);
      return;
    }
    if ((this.Ily != null) && (this.Ily.msg_options != null) && (this.Ily.msg_options.bg_type == 2)) {
      localGradientDrawable.setColor(com.tencent.mm.plugin.game.chatroom.e.aFs("#665A33").intValue());
    }
    for (;;)
    {
      com.tencent.threadpool.h.ahAA.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(275976);
          k.b(k.this);
          AppMethodBeat.o(275976);
        }
      }, 3000L);
      AppMethodBeat.o(276145);
      return;
      localGradientDrawable.setColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.game.chatroom.h.b.BW_100_Alpha_0_1));
    }
  }
  
  public final void fCQ()
  {
    AppMethodBeat.i(276150);
    if ((this.Ily == null) || (this.Ily.seq != this.IlX)) {
      fCO();
    }
    AppMethodBeat.o(276150);
  }
  
  public final void fCR()
  {
    AppMethodBeat.i(276165);
    if ((this.Ily == null) || (this.IlC == null))
    {
      AppMethodBeat.o(276165);
      return;
    }
    Object localObject = (b.e)this.IlY.get(this.Ily.from_username);
    if ((localObject != null) && (!Util.isNullOrNil(((b.e)localObject).iconUrl)))
    {
      com.tencent.mm.plugin.game.d.e.fIb().p(this.IlC, ((b.e)localObject).iconUrl);
      if (((b.e)localObject).Ieg != null)
      {
        localObject = com.tencent.mm.plugin.game.chatroom.e.aFs(Util.nullAsNil(((b.e)localObject).Ieg.dark_color));
        if (localObject != null)
        {
          GradientDrawable localGradientDrawable = (GradientDrawable)this.IlC.getBackground();
          if (localGradientDrawable != null) {
            localGradientDrawable.setColor(((Integer)localObject).intValue());
          }
        }
      }
      this.IlC.setVisibility(0);
      AppMethodBeat.o(276165);
      return;
    }
    this.IlC.setVisibility(8);
    AppMethodBeat.o(276165);
  }
  
  protected final boolean fCS()
  {
    AppMethodBeat.i(276169);
    boolean bool = com.tencent.mm.plugin.game.chatroom.e.aFq(this.lBQ).IdU;
    AppMethodBeat.o(276169);
    return bool;
  }
  
  protected final boolean fCT()
  {
    AppMethodBeat.i(276175);
    boolean bool = com.tencent.mm.plugin.game.chatroom.e.aFq(this.lBQ).IdV;
    AppMethodBeat.o(276175);
    return bool;
  }
  
  public final boolean fCU()
  {
    AppMethodBeat.i(276223);
    if (this.IlP != null)
    {
      if (this.IlP.getVisibility() == 0)
      {
        AppMethodBeat.o(276223);
        return true;
      }
      AppMethodBeat.o(276223);
      return false;
    }
    AppMethodBeat.o(276223);
    return false;
  }
  
  protected void o(com.tencent.mm.ui.base.s params) {}
  
  public static final class a
  {
    public static k az(View paramView, int paramInt)
    {
      AppMethodBeat.i(275977);
      Object localObject = com.tencent.mm.plugin.game.chatroom.d.Xa(paramInt);
      if (localObject == null)
      {
        paramView = new k(paramView, paramInt);
        AppMethodBeat.o(275977);
        return paramView;
      }
      try
      {
        localObject = ((Class)localObject).getDeclaredConstructor(new Class[] { View.class, Integer.TYPE });
        ((Constructor)localObject).setAccessible(true);
        paramView = (k)((Constructor)localObject).newInstance(new Object[] { paramView, Integer.valueOf(paramInt) });
        AppMethodBeat.o(275977);
        return paramView;
      }
      catch (NoSuchMethodException paramView)
      {
        Log.e("GameChatRoom.GameChatItemVH", "err_1:%s", new Object[] { paramView.getMessage() });
        AppMethodBeat.o(275977);
        return null;
      }
      catch (IllegalAccessException paramView)
      {
        for (;;)
        {
          Log.e("GameChatRoom.GameChatItemVH", "err_2:%s", new Object[] { paramView.getMessage() });
        }
      }
      catch (InstantiationException paramView)
      {
        for (;;)
        {
          Log.e("GameChatRoom.GameChatItemVH", "err_3:%s", new Object[] { paramView.getMessage() });
        }
      }
      catch (InvocationTargetException paramView)
      {
        for (;;)
        {
          Log.e("GameChatRoom.GameChatItemVH", "err_4:%s", new Object[] { paramView.getMessage() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.i.k
 * JD-Core Version:    0.7.0.1
 */