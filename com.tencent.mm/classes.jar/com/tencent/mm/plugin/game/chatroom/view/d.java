package com.tencent.mm.plugin.game.chatroom.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import com.tencent.mm.plugin.game.chatroom.h.b;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public abstract class d
  extends a
{
  public Object mData;
  
  public d(Object paramObject)
  {
    super(1);
    this.mData = paramObject;
  }
  
  public void setColorConfig(int paramInt)
  {
    Context localContext = MMApplicationContext.getContext();
    setColor(Color.parseColor("#7D90A9"), localContext.getResources().getColor(h.b.BW_100_Alpha_0_0_5));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.d
 * JD-Core Version:    0.7.0.1
 */