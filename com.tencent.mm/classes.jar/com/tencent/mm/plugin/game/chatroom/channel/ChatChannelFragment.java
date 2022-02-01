package com.tencent.mm.plugin.game.chatroom.channel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.pr;
import com.tencent.mm.plugin.game.autogen.chatroom.Channel;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomJumpInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.JumpInfo;
import com.tencent.mm.plugin.game.chatroom.b.e;
import com.tencent.mm.plugin.game.chatroom.b.c;
import com.tencent.mm.plugin.game.chatroom.g.a;
import com.tencent.mm.plugin.game.chatroom.h.e;
import com.tencent.mm.plugin.game.chatroom.h.f;
import com.tencent.mm.plugin.game.chatroom.view.GameChatListView;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import java.util.Map;

public class ChatChannelFragment
  extends Fragment
  implements b
{
  public GameChatListView IjA;
  private int IjB;
  Channel IjC;
  List<Channel> IjD;
  public int IjE;
  private int IjF;
  private c IjG;
  private ChatroomJumpInfo IjH;
  private JumpInfo IjI;
  private String IjJ;
  private long IjK;
  private pr IjL;
  private IListener IjM;
  private String lBQ;
  private View mContentView;
  public boolean xVI;
  
  public ChatChannelFragment(String paramString, int paramInt)
  {
    AppMethodBeat.i(275712);
    this.xVI = false;
    this.IjF = -1;
    this.IjM = new IListener(f.hfK) {};
    this.lBQ = paramString;
    this.IjB = paramInt;
    AppMethodBeat.o(275712);
  }
  
  private void aFt(String paramString)
  {
    AppMethodBeat.i(275735);
    if (this.IjA != null) {
      this.IjA.aFt(paramString);
    }
    AppMethodBeat.o(275735);
  }
  
  private void eoD()
  {
    AppMethodBeat.i(275729);
    if (this.xVI) {
      we(false);
    }
    if (this.IjA != null)
    {
      if (this.xVI)
      {
        this.IjA.a(this.IjL);
        this.IjL = null;
        AppMethodBeat.o(275729);
        return;
      }
      this.IjA.onPause();
    }
    AppMethodBeat.o(275729);
  }
  
  private void we(boolean paramBoolean)
  {
    AppMethodBeat.i(275721);
    if ((this.mContentView == null) || (this.IjA != null))
    {
      AppMethodBeat.o(275721);
      return;
    }
    Log.i("GameChatRoom.ChatChannelFragment", "ChatChannelFragment initChatList, channelId:%d", new Object[] { Integer.valueOf(this.IjE) });
    ((ViewStub)this.mContentView.findViewById(h.e.Ihx)).inflate();
    this.IjA = ((GameChatListView)this.mContentView.findViewById(h.e.IfP));
    this.IjA.setChatRoomInfo(this.lBQ);
    this.IjA.M(this.IjE, this.IjD);
    this.IjA.hw(this.mContentView);
    this.IjA.getFirstPageData();
    if (this.IjG != null) {
      setHostContact(this.IjG);
    }
    if (this.IjH != null) {
      setChatRoomJumpInfo(this.IjH);
    }
    if (this.IjI != null) {
      setPreloadInfo(this.IjI);
    }
    if (this.IjJ != null) {
      setPremadeCardInfo(this.IjJ);
    }
    if (this.IjK != 0L) {
      setJumpFirstSeq(this.IjK);
    }
    eoD();
    if ((paramBoolean) && (this.IjF == -1)) {
      aFt(this.lBQ);
    }
    AppMethodBeat.o(275721);
  }
  
  public final void Xg(int paramInt) {}
  
  public final void ap(Map<String, b.e> paramMap)
  {
    AppMethodBeat.i(275768);
    if (this.IjA != null) {
      this.IjA.ap(paramMap);
    }
    AppMethodBeat.o(275768);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(275754);
    this.IjM.alive();
    int i;
    if (this.mContentView == null)
    {
      this.mContentView = paramLayoutInflater.inflate(h.f.Ihy, paramViewGroup, false);
      this.IjF = ((Activity)paramViewGroup.getContext()).getIntent().getIntExtra("target_channel_id", -1);
      if ((!g.a.Xd(this.IjE)) && (this.IjE != this.IjB)) {
        break label98;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0) {}
      try
      {
        we(true);
        paramLayoutInflater = this.mContentView;
        AppMethodBeat.o(275754);
        return paramLayoutInflater;
        label98:
        i = 0;
      }
      catch (Exception paramLayoutInflater)
      {
        for (;;)
        {
          Log.i("GameChatRoom.ChatChannelFragment", "err:" + paramLayoutInflater.getMessage());
        }
      }
    }
  }
  
  public void onDestroyView()
  {
    AppMethodBeat.i(275759);
    super.onDestroyView();
    this.IjM.dead();
    AppMethodBeat.o(275759);
  }
  
  public final void setChatRoomJumpInfo(ChatroomJumpInfo paramChatroomJumpInfo)
  {
    AppMethodBeat.i(275786);
    this.IjH = paramChatroomJumpInfo;
    if (this.IjA != null) {
      this.IjA.setChatRoomJumpInfo(paramChatroomJumpInfo);
    }
    AppMethodBeat.o(275786);
  }
  
  public final void setHostContact(c paramc)
  {
    AppMethodBeat.i(275778);
    this.IjG = paramc;
    if (this.IjA != null) {
      this.IjA.setHostContact(paramc);
    }
    AppMethodBeat.o(275778);
  }
  
  public final void setJumpFirstSeq(long paramLong)
  {
    AppMethodBeat.i(275808);
    this.IjK = paramLong;
    if (this.IjA != null) {
      this.IjA.setJumpFirstSeq(paramLong);
    }
    AppMethodBeat.o(275808);
  }
  
  public final void setPreloadInfo(JumpInfo paramJumpInfo)
  {
    AppMethodBeat.i(275793);
    this.IjI = paramJumpInfo;
    if (this.IjA != null) {
      this.IjA.setPreloadInfo(paramJumpInfo);
    }
    AppMethodBeat.o(275793);
  }
  
  public final void setPremadeCardInfo(String paramString)
  {
    AppMethodBeat.i(275800);
    this.IjJ = paramString;
    if (this.IjA != null) {
      this.IjA.setPremadeCardInfo(paramString);
    }
    AppMethodBeat.o(275800);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    AppMethodBeat.i(275763);
    super.setUserVisibleHint(paramBoolean);
    this.xVI = paramBoolean;
    eoD();
    AppMethodBeat.o(275763);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.channel.ChatChannelFragment
 * JD-Core Version:    0.7.0.1
 */