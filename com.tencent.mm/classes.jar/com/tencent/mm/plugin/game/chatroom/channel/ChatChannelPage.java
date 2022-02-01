package com.tencent.mm.plugin.game.chatroom.channel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.b;
import com.google.android.material.tabs.TabLayout.e;
import com.google.android.material.tabs.TabLayout.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.bm;
import com.tencent.mm.autogen.a.kr;
import com.tencent.mm.autogen.a.kr.a;
import com.tencent.mm.autogen.a.lf;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.plugin.game.autogen.chatroom.Channel;
import com.tencent.mm.plugin.game.autogen.chatroom.ChannelInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomJumpInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.GetMyChatroomResponse;
import com.tencent.mm.plugin.game.autogen.chatroom.JumpInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.SetChatroomMsgChosenRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.VoteInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.VoteMsgRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.VoteMsgResponse;
import com.tencent.mm.plugin.game.chatroom.b.e;
import com.tencent.mm.plugin.game.chatroom.c.i;
import com.tencent.mm.plugin.game.chatroom.c.t;
import com.tencent.mm.plugin.game.chatroom.e;
import com.tencent.mm.plugin.game.chatroom.g.a;
import com.tencent.mm.plugin.game.chatroom.h.b;
import com.tencent.mm.plugin.game.chatroom.h.e;
import com.tencent.mm.plugin.game.chatroom.h.f;
import com.tencent.mm.plugin.game.chatroom.h.g;
import com.tencent.mm.plugin.game.chatroom.h.h;
import com.tencent.mm.plugin.game.chatroom.view.GameChatListView;
import com.tencent.mm.plugin.game.chatroom.view.GameChatRoomSelectView;
import com.tencent.mm.plugin.game.chatroom.view.GameChatRoomSelectView.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.aa.b;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ChatChannelPage
  extends LinearLayout
  implements com.tencent.mm.am.h, b
{
  private int IjF;
  public TabLayout IjO;
  public ViewGroup IjP;
  public a IjQ;
  private com.tencent.mm.plugin.game.chatroom.b.d IjR;
  private int IjS;
  private boolean IjT;
  private ChannelInfo IjU;
  private Map<Integer, ChatChannelFragment> IjV;
  private j IjW;
  private boolean IjX;
  private long IjY;
  private IListener IjZ;
  private long Ijq;
  private long Ijr;
  private IListener Ika;
  private String lBQ;
  private Context mContext;
  CustomViewPager mViewPager;
  public View plc;
  
  public ChatChannelPage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(275734);
    this.IjV = new HashMap();
    this.IjX = false;
    this.IjF = -1;
    this.IjY = -1L;
    this.IjZ = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Ika = new IListener(com.tencent.mm.app.f.hfK) {};
    this.mContext = getContext();
    this.Ijr = ((Activity)this.mContext).getIntent().getLongExtra("game_report_sourceid", 0L);
    this.Ijq = ((Activity)this.mContext).getIntent().getLongExtra("game_report_ssid", 0L);
    this.IjF = ((Activity)this.mContext).getIntent().getIntExtra("target_channel_id", -1);
    this.IjY = ((Activity)this.mContext).getIntent().getLongExtra("target_seq", -1L);
    LayoutInflater.from(this.mContext).inflate(h.f.IhA, this);
    this.IjP = ((ViewGroup)findViewById(h.e.Iha));
    this.IjP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(275740);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/channel/ChatChannelPage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        com.tencent.mm.game.report.d.mty.a(20L, 2L, ChatChannelPage.a(ChatChannelPage.this), ChatChannelPage.b(ChatChannelPage.this), 0L, "", 0);
        if (!ChatChannelPage.c(ChatChannelPage.this))
        {
          ChatChannelPage.d(ChatChannelPage.this);
          paramAnonymousView = new i(null, "", "", 2, 19527);
          com.tencent.mm.kernel.h.aZW().a(paramAnonymousView, 0);
          ChatChannelPage.a(ChatChannelPage.this, new j(ChatChannelPage.e(ChatChannelPage.this), 0, 0, true, (byte)0));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/channel/ChatChannelPage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(275740);
      }
    });
    this.mViewPager = ((CustomViewPager)findViewById(h.e.view_pager));
    this.IjQ = new a(((MMFragmentActivity)this.mContext).getSupportFragmentManager());
    AppMethodBeat.o(275734);
  }
  
  public final void Xg(int paramInt)
  {
    AppMethodBeat.i(275910);
    if (this.IjQ != null) {
      this.IjQ.Xg(paramInt);
    }
    AppMethodBeat.o(275910);
  }
  
  public final void a(String paramString, ChannelInfo paramChannelInfo)
  {
    for (;;)
    {
      Object localObject1;
      try
      {
        AppMethodBeat.i(275885);
        if ((paramChannelInfo == null) || (Util.isNullOrNil(paramChannelInfo.channel_list)))
        {
          AppMethodBeat.o(275885);
          return;
        }
        Log.i("GameChatRoom.ChatChannelPage", "channel tab init");
        this.IjU = paramChannelInfo;
        this.IjT = true;
        this.IjO.WY();
        this.IjO.dyi.clear();
        this.IjO.a(new TabLayout.b()
        {
          public final void i(TabLayout.e paramAnonymouse)
          {
            boolean bool2 = false;
            int i = 1;
            AppMethodBeat.i(275725);
            Log.i("GameChatRoom.ChatChannelPage", "select tab:%d", new Object[] { Integer.valueOf(paramAnonymouse.position) });
            ChatChannelPage.g(ChatChannelPage.this).setCurrentItem(paramAnonymouse.position);
            ChatChannelPage.a(ChatChannelPage.this, paramAnonymouse, true);
            ChatChannelFragment localChatChannelFragment = (ChatChannelFragment)ChatChannelPage.h(ChatChannelPage.this).getItem(paramAnonymouse.position);
            String str;
            com.tencent.mm.plugin.game.chatroom.b.d locald;
            if ((ChatChannelPage.i(ChatChannelPage.this) != null) && (localChatChannelFragment != null))
            {
              str = "";
              if (!localChatChannelFragment.IjC.read_only) {
                break label275;
              }
              str = localChatChannelFragment.IjC.cant_send_reason;
              locald = ChatChannelPage.i(ChatChannelPage.this);
              if (localChatChannelFragment.IjC.read_only) {
                break label317;
              }
            }
            label275:
            label317:
            for (boolean bool1 = true;; bool1 = false)
            {
              locald.an(bool1, str);
              bool1 = bool2;
              if (!g.a.Xd(localChatChannelFragment.IjC.channel_id)) {
                bool1 = true;
              }
              ChatChannelPage.i(ChatChannelPage.this).a(bool1, localChatChannelFragment.IjC);
              ChatChannelPage.a(ChatChannelPage.this, localChatChannelFragment.IjC.channel_id);
              if (!ChatChannelPage.j(ChatChannelPage.this))
              {
                if ((paramAnonymouse.tag instanceof Integer)) {
                  i = ((Integer)paramAnonymouse.tag).intValue();
                }
                com.tencent.mm.game.report.d.mty.a(i, 2L, ChatChannelPage.a(ChatChannelPage.this), ChatChannelPage.b(ChatChannelPage.this), ChatChannelPage.k(ChatChannelPage.this));
              }
              ChatChannelPage.l(ChatChannelPage.this);
              AppMethodBeat.o(275725);
              return;
              if (g.a.Xd(localChatChannelFragment.IjC.channel_id)) {
                break;
              }
              str = "# " + localChatChannelFragment.IjC.name;
              break;
            }
          }
          
          public final void j(TabLayout.e paramAnonymouse)
          {
            AppMethodBeat.i(275732);
            ChatChannelPage.a(ChatChannelPage.this, paramAnonymouse, false);
            AppMethodBeat.o(275732);
          }
          
          public final void k(TabLayout.e paramAnonymouse) {}
        });
        this.mViewPager.addOnPageChangeListener(new TabLayout.f(this.IjO));
        if ((this.IjQ.getCount() != 0) && (this.IjR != null))
        {
          this.IjR.an(true, "");
          this.IjR.a(false, null);
        }
        this.IjQ.Ijz.clear();
        i = 0;
        if (i >= paramChannelInfo.channel_list.size()) {
          break label652;
        }
        localObject1 = (Channel)paramChannelInfo.channel_list.get(i);
        if (this.IjF != ((Channel)localObject1).channel_id) {
          break label645;
        }
        paramChannelInfo.default_channel_id = this.IjF;
      }
      finally {}
      if (i < paramChannelInfo.channel_list.size())
      {
        Channel localChannel = (Channel)paramChannelInfo.channel_list.get(i);
        localObject1 = this.IjO.WW();
        Object localObject2 = LayoutInflater.from(this.mContext).inflate(h.f.Ihz, null);
        Object localObject3 = (TextView)((View)localObject2).findViewById(h.e.Ihb);
        TextView localTextView = (TextView)((View)localObject2).findViewById(h.e.Ihc);
        StringBuffer localStringBuffer = new StringBuffer();
        if ((!g.a.Xd(localChannel.channel_id)) && (!g.a.Xe(localChannel.channel_id))) {
          localStringBuffer.append("# ");
        }
        localStringBuffer.append(localChannel.name);
        ((TextView)localObject3).setText(localStringBuffer);
        if (localChannel.unread_msg_count != 0L)
        {
          localTextView.setVisibility(0);
          localTextView.setText("+" + localChannel.unread_msg_count);
          localObject3 = ((TabLayout.e)localObject1).cG((View)localObject2);
          this.IjO.a((TabLayout.e)localObject3, false);
          localObject2 = (ChatChannelFragment)this.IjV.get(Integer.valueOf(localChannel.channel_id));
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new ChatChannelFragment(paramString, paramChannelInfo.default_channel_id);
            this.IjV.put(Integer.valueOf(localChannel.channel_id), localObject1);
          }
          localObject2 = paramChannelInfo.channel_list;
          ((ChatChannelFragment)localObject1).IjC = localChannel;
          ((ChatChannelFragment)localObject1).IjE = localChannel.channel_id;
          ((ChatChannelFragment)localObject1).IjD = ((List)localObject2);
          if (((ChatChannelFragment)localObject1).IjA != null) {
            ((ChatChannelFragment)localObject1).IjA.M(((ChatChannelFragment)localObject1).IjE, (List)localObject2);
          }
          this.IjQ.Ijz.add(localObject1);
          if (paramChannelInfo.default_channel_id == localChannel.channel_id)
          {
            j = i;
            com.tencent.mm.game.report.d.mty.a(i + 1, 1L, this.Ijq, this.Ijr, localChannel.channel_id);
            ((TabLayout.e)localObject3).tag = Integer.valueOf(i + 1);
            i += 1;
          }
        }
        else
        {
          localTextView.setVisibility(8);
          continue;
        }
      }
      else
      {
        this.mViewPager.setOffscreenPageLimit(20);
        this.mViewPager.setAdapter(this.IjQ);
        this.IjO.js(j).Xf();
        AppMethodBeat.o(275885);
        continue;
      }
      continue;
      label645:
      i += 1;
      continue;
      label652:
      int j = 0;
      int i = 0;
    }
  }
  
  public final ChannelInfo aFu(String paramString)
  {
    AppMethodBeat.i(275852);
    this.lBQ = paramString;
    if (this.IjF != -1) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(275852);
      return null;
    }
    Object localObject = new kr();
    ((kr)localObject).hMp.hAf = 1;
    ((kr)localObject).hMp.key = ("cache_game_chat_msg#" + paramString + "#channel");
    ((kr)localObject).publish();
    localObject = ((kr)localObject).hMp.value;
    if (!Util.isNullOrNil((byte[])localObject)) {}
    for (;;)
    {
      try
      {
        paramString = new ChannelInfo();
        paramString.parseFrom((byte[])localObject);
        AppMethodBeat.o(275852);
        return paramString;
      }
      catch (IOException paramString)
      {
        paramString = null;
        continue;
      }
      paramString = null;
    }
  }
  
  public final void ap(Map<String, b.e> paramMap)
  {
    AppMethodBeat.i(275904);
    if (this.IjQ != null) {
      this.IjQ.ap(paramMap);
    }
    AppMethodBeat.o(275904);
  }
  
  public final void fCF()
  {
    AppMethodBeat.i(275938);
    if (this.IjQ != null)
    {
      Iterator localIterator = this.IjQ.Ijz.iterator();
      while (localIterator.hasNext())
      {
        ChatChannelFragment localChatChannelFragment = (ChatChannelFragment)localIterator.next();
        if (localChatChannelFragment.IjA != null) {
          localChatChannelFragment.IjA.fCF();
        }
      }
    }
    AppMethodBeat.o(275938);
  }
  
  public Channel getRookieChannel()
  {
    AppMethodBeat.i(275866);
    if ((this.IjU != null) && (this.IjU.channel_list != null))
    {
      Iterator localIterator = this.IjU.channel_list.iterator();
      while (localIterator.hasNext())
      {
        Channel localChannel = (Channel)localIterator.next();
        if (g.a.Xf(localChannel.channel_id))
        {
          AppMethodBeat.o(275866);
          return localChannel;
        }
      }
    }
    AppMethodBeat.o(275866);
    return null;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(275829);
    super.onAttachedToWindow();
    com.tencent.mm.kernel.h.aZW().a(4383, this);
    com.tencent.mm.kernel.h.aZW().a(4569, this);
    com.tencent.mm.kernel.h.aZW().a(4989, this);
    this.IjZ.alive();
    this.Ika.alive();
    AppMethodBeat.o(275829);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(275839);
    super.onDetachedFromWindow();
    com.tencent.mm.kernel.h.aZW().b(4383, this);
    com.tencent.mm.kernel.h.aZW().b(4569, this);
    com.tencent.mm.kernel.h.aZW().b(4989, this);
    this.IjZ.dead();
    this.Ika.dead();
    kr localkr;
    if ((this.IjU != null) && (this.lBQ != null))
    {
      localkr = new kr();
      localkr.hMp.hAf = 2;
      localkr.hMp.key = ("cache_game_chat_msg#" + this.lBQ + "#channel");
    }
    try
    {
      localkr.hMp.value = this.IjU.toByteArray();
      label131:
      localkr.publish();
      if (this.IjW != null)
      {
        this.IjW.cyW();
        this.IjW = null;
      }
      this.IjX = false;
      AppMethodBeat.o(275839);
      return;
    }
    catch (IOException localIOException)
    {
      break label131;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(275897);
    int i = paramp.getType();
    if (i == 4383)
    {
      boolean bool = ((SetChatroomMsgChosenRequest)c.b.b(((com.tencent.mm.plugin.game.chatroom.c.q)paramp).mtC.otB)).is_chosen;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.mContext;
        paramp = MMApplicationContext.getResources();
        if (bool) {}
        for (paramInt1 = h.h.Iit;; paramInt1 = h.h.Iiv)
        {
          aa.db(paramString, paramp.getString(paramInt1));
          AppMethodBeat.o(275897);
          return;
        }
      }
      paramString = this.mContext;
      paramp = MMApplicationContext.getResources();
      if (bool) {}
      for (paramInt1 = h.h.Iis;; paramInt1 = h.h.Iiu)
      {
        aa.dc(paramString, paramp.getString(paramInt1));
        AppMethodBeat.o(275897);
        return;
      }
    }
    if (i == 4569)
    {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acSV, Integer.valueOf(1));
      paramString = (t)paramp;
      paramp = c.b.b(paramString.mtC.otB);
      if (paramp == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.game.autogen.chatroom.VoteMsgRequest");
        AppMethodBeat.o(275897);
        throw paramString;
      }
      paramp = (VoteMsgRequest)paramp;
      Object localObject = c.c.b(paramString.mtC.otC);
      if (localObject == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.game.autogen.chatroom.VoteMsgResponse");
        AppMethodBeat.o(275897);
        throw paramString;
      }
      localObject = (VoteMsgResponse)localObject;
      if (((VoteMsgResponse)localObject).education_jump_info != null) {
        e.a(this.mContext, ((VoteMsgResponse)localObject).education_jump_info, 0, null);
      }
      VoteInfo localVoteInfo = ((VoteMsgResponse)localObject).vote_info;
      d.a locala;
      if (localVoteInfo != null)
      {
        if (!localVoteInfo.voted_by_me) {
          break label401;
        }
        aa.a(this.mContext, this.mContext.getString(h.h.IiW), new aa.b()
        {
          public final void onViewCustomize(View paramAnonymousView)
          {
            AppMethodBeat.i(275744);
            paramAnonymousView = (WeImageView)paramAnonymousView.findViewById(h.e.toast_img);
            if (paramAnonymousView != null)
            {
              paramAnonymousView.setIconColor(ChatChannelPage.e(ChatChannelPage.this).getResources().getColor(h.b.transparent));
              paramAnonymousView.setImageResource(h.g.icons_filled_game_favour);
            }
            AppMethodBeat.o(275744);
          }
        });
        locala = com.tencent.mm.game.report.d.mty;
        d.a.a(paramString.Ijx.intValue(), 37L, this.Ijq, this.Ijr, paramString.Ijw.longValue(), paramString.userName, 0L, this.IjS, ((VoteMsgResponse)localObject).report_ext_info);
      }
      for (;;)
      {
        long l = paramp.seq;
        if (this.IjQ != null) {
          this.IjQ.a(l, localVoteInfo);
        }
        AppMethodBeat.o(275897);
        return;
        label401:
        locala = com.tencent.mm.game.report.d.mty;
        d.a.a(paramString.Ijx.intValue(), 2L, this.Ijq, this.Ijr, paramString.Ijw.longValue(), paramString.userName, 0L, this.IjS, ((VoteMsgResponse)localObject).report_ext_info);
      }
    }
    if (i == 4989)
    {
      paramString = (i)paramp;
      if ((paramString == null) || (paramString.DD != 19527))
      {
        AppMethodBeat.o(275897);
        return;
      }
      this.IjX = false;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((i)paramp).fCB();
        if ((paramString != null) && (this.IjQ != null))
        {
          paramString = paramString.my_chatroom_info_list;
          if ((this.IjW != null) && (!Util.isNullOrNil(paramString)))
          {
            this.IjW.cyW();
            paramp = new GameChatRoomSelectView(this.mContext);
            paramp.setOnCloseListener(new GameChatRoomSelectView.a()
            {
              public final void bfj()
              {
                AppMethodBeat.i(275715);
                ChatChannelPage.f(ChatChannelPage.this).cyW();
                AppMethodBeat.o(275715);
              }
            });
            paramp.setData(paramString);
            this.IjW.F(paramp, 0, 0);
            this.IjW.dDn();
          }
        }
      }
    }
    AppMethodBeat.o(275897);
  }
  
  public void setChatRoomJumpInfo(ChatroomJumpInfo paramChatroomJumpInfo)
  {
    AppMethodBeat.i(275922);
    if (this.IjQ != null)
    {
      Iterator localIterator = this.IjQ.Ijz.iterator();
      while (localIterator.hasNext()) {
        ((ChatChannelFragment)localIterator.next()).setChatRoomJumpInfo(paramChatroomJumpInfo);
      }
    }
    AppMethodBeat.o(275922);
  }
  
  public void setHostContact(com.tencent.mm.plugin.game.chatroom.b.c paramc)
  {
    AppMethodBeat.i(275918);
    if (this.IjQ != null)
    {
      Iterator localIterator = this.IjQ.Ijz.iterator();
      while (localIterator.hasNext()) {
        ((ChatChannelFragment)localIterator.next()).setHostContact(paramc);
      }
    }
    AppMethodBeat.o(275918);
  }
  
  public void setJumpFirstSeq(long paramLong)
  {
    AppMethodBeat.i(275947);
    if (this.IjQ != null)
    {
      Iterator localIterator = this.IjQ.Ijz.iterator();
      while (localIterator.hasNext()) {
        ((ChatChannelFragment)localIterator.next()).setJumpFirstSeq(paramLong);
      }
    }
    AppMethodBeat.o(275947);
  }
  
  public void setPreloadInfo(JumpInfo paramJumpInfo)
  {
    AppMethodBeat.i(275927);
    if (this.IjQ != null)
    {
      Iterator localIterator = this.IjQ.Ijz.iterator();
      while (localIterator.hasNext()) {
        ((ChatChannelFragment)localIterator.next()).setPreloadInfo(paramJumpInfo);
      }
    }
    AppMethodBeat.o(275927);
  }
  
  public void setPremadeCardInfo(String paramString)
  {
    AppMethodBeat.i(275931);
    if (this.IjQ != null)
    {
      Iterator localIterator = this.IjQ.Ijz.iterator();
      while (localIterator.hasNext()) {
        ((ChatChannelFragment)localIterator.next()).setPremadeCardInfo(paramString);
      }
    }
    AppMethodBeat.o(275931);
  }
  
  public void setUICallback(com.tencent.mm.plugin.game.chatroom.b.d paramd)
  {
    this.IjR = paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.channel.ChatChannelPage
 * JD-Core Version:    0.7.0.1
 */