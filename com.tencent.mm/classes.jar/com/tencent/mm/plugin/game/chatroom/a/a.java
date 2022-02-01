package com.tencent.mm.plugin.game.chatroom.a;

import android.app.ActivityOptions;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.plugin.game.autogen.chatroom.Lbs;

public abstract interface a
  extends com.tencent.mm.kernel.b.a
{
  public abstract void callAtFunction(String paramString1, String paramString2, String paramString3);
  
  public abstract void enterGameChatRoom(Context paramContext, String paramString1, String paramString2, Lbs paramLbs, boolean paramBoolean1, long paramLong1, long paramLong2, Bundle paramBundle, ActivityOptions paramActivityOptions, boolean paramBoolean2);
  
  public abstract void enterGameChatRoomFromFind(Context paramContext, String paramString1, String paramString2, long paramLong1, long paramLong2);
  
  public abstract boolean enterGameChatRoomFromWeb(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2, Bundle paramBundle, int paramInt1, long paramLong3, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.a.a
 * JD-Core Version:    0.7.0.1
 */