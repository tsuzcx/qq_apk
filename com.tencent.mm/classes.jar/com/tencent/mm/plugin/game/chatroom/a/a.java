package com.tencent.mm.plugin.game.chatroom.a;

import android.app.ActivityOptions;
import android.content.Context;
import com.tencent.mm.plugin.game.autogen.chatroom.Lbs;

public abstract interface a
  extends com.tencent.mm.kernel.b.a
{
  public abstract void enterGameChatRoom(Context paramContext, String paramString1, String paramString2, Lbs paramLbs, boolean paramBoolean, long paramLong1, long paramLong2, ActivityOptions paramActivityOptions);
  
  public abstract void enterGameChatRoomFromWeb(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.a.a
 * JD-Core Version:    0.7.0.1
 */