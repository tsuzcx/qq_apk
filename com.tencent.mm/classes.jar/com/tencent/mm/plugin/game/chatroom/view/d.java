package com.tencent.mm.plugin.game.chatroom.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import com.tencent.mm.plugin.game.chatroom.f.b;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public abstract class d
  extends a
{
  public d()
  {
    super(1, null);
  }
  
  public void setColorConfig(int paramInt)
  {
    Context localContext = MMApplicationContext.getContext();
    setColor(Color.parseColor("#7D90A9"), localContext.getResources().getColor(f.b.BW_100_Alpha_0_0_5));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.d
 * JD-Core Version:    0.7.0.1
 */