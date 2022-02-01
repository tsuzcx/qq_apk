package com.tencent.mm.plugin.game.chatroom.channel;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.m;
import androidx.fragment.app.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.autogen.chatroom.Channel;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgPack;
import com.tencent.mm.plugin.game.autogen.chatroom.VoteInfo;
import com.tencent.mm.plugin.game.chatroom.b.e;
import com.tencent.mm.plugin.game.chatroom.i.k;
import com.tencent.mm.plugin.game.chatroom.view.GameChatListView;
import com.tencent.mm.plugin.game.chatroom.view.GameChatListView.b;
import com.tencent.mm.plugin.game.chatroom.view.GameChatListView.b.5;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class a
  extends m
  implements b
{
  private FragmentManager Ijy;
  public List<ChatChannelFragment> Ijz;
  
  public a(FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
    AppMethodBeat.i(275737);
    this.Ijz = new ArrayList();
    this.Ijy = paramFragmentManager;
    AppMethodBeat.o(275737);
  }
  
  public final void Xg(int paramInt)
  {
    AppMethodBeat.i(275771);
    Iterator localIterator = this.Ijz.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(275771);
  }
  
  public final ChatChannelFragment Xh(int paramInt)
  {
    AppMethodBeat.i(275743);
    Iterator localIterator = this.Ijz.iterator();
    while (localIterator.hasNext())
    {
      ChatChannelFragment localChatChannelFragment = (ChatChannelFragment)localIterator.next();
      if ((localChatChannelFragment.IjC != null) && (localChatChannelFragment.IjC.channel_id == paramInt))
      {
        AppMethodBeat.o(275743);
        return localChatChannelFragment;
      }
    }
    AppMethodBeat.o(275743);
    return null;
  }
  
  public final void a(long paramLong, VoteInfo paramVoteInfo)
  {
    AppMethodBeat.i(275781);
    Iterator localIterator = this.Ijz.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ChatChannelFragment)localIterator.next();
      if (((ChatChannelFragment)localObject).IjA != null)
      {
        localObject = ((ChatChannelFragment)localObject).IjA;
        if (((GameChatListView)localObject).IqW != null)
        {
          localObject = ((GameChatListView)localObject).IqW;
          h.ahAA.bm(new GameChatListView.b.5((GameChatListView.b)localObject, paramLong, paramVoteInfo));
          localObject = ((GameChatListView.b)localObject).IrB.iterator();
          while (((Iterator)localObject).hasNext())
          {
            k localk = (k)((Iterator)localObject).next();
            if ((localk.Ily != null) && (localk.Ily.seq == paramLong)) {
              localk.a(paramVoteInfo);
            }
          }
        }
      }
    }
    AppMethodBeat.o(275781);
  }
  
  public final void ap(Map<String, b.e> paramMap)
  {
    AppMethodBeat.i(275767);
    Iterator localIterator = this.Ijz.iterator();
    while (localIterator.hasNext()) {
      ((ChatChannelFragment)localIterator.next()).ap(paramMap);
    }
    AppMethodBeat.o(275767);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(275753);
    int i = this.Ijz.size();
    AppMethodBeat.o(275753);
    return i;
  }
  
  public final Fragment getItem(int paramInt)
  {
    AppMethodBeat.i(275746);
    Object localObject = this.Ijz;
    localObject = (Fragment)((List)localObject).get(paramInt % ((List)localObject).size());
    AppMethodBeat.o(275746);
    return localObject;
  }
  
  public final int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(275761);
    try
    {
      localr = this.Ijy.beginTransaction();
      i = 0;
    }
    catch (Exception paramViewGroup)
    {
      for (;;)
      {
        r localr;
        int i;
        long l;
        int j;
        Object localObject;
        Log.i("GameChatRoom.ChatChannelAdapter", "err:" + paramViewGroup.getMessage());
        continue;
        i += 1;
      }
    }
    if (i < getCount())
    {
      l = i;
      j = paramViewGroup.getId();
      localObject = "android:switcher:" + j + ":" + l;
      localObject = this.Ijy.findFragmentByTag((String)localObject);
      if (localObject != null)
      {
        localr.a((Fragment)localObject);
        Log.e("GameChatRoom.ChatChannelAdapter", "Remove### " + ((Fragment)localObject).getId() + " " + ((Fragment)localObject).isAdded() + " " + ((Fragment)localObject).isHidden());
      }
    }
    else
    {
      localObject = getItem(paramInt);
      Log.e("GameChatRoom.ChatChannelAdapter", "### " + ((Fragment)localObject).getId() + " " + ((Fragment)localObject).isAdded() + " " + ((Fragment)localObject).isHidden());
      if (!((Fragment)localObject).isAdded()) {
        localr.a(paramViewGroup.getId(), (Fragment)localObject).r((Fragment)localObject).FX();
      }
      paramViewGroup = getItem(paramInt);
      AppMethodBeat.o(275761);
      return paramViewGroup;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.channel.a
 * JD-Core Version:    0.7.0.1
 */