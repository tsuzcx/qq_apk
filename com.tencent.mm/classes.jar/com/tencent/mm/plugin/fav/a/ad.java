package com.tencent.mm.plugin.fav.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.message.k.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.applet.y.a;

public abstract interface ad
  extends a
{
  public abstract int a(k.b paramb, WXMediaMessage paramWXMediaMessage, String paramString);
  
  public abstract int a(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3);
  
  public abstract void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent, int paramInt3, int paramInt4);
  
  public abstract void a(Context paramContext, String paramString, g paramg, int paramInt, boolean paramBoolean, y.a parama);
  
  public abstract int aul(String paramString);
  
  public abstract void b(Activity paramActivity, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ad
 * JD-Core Version:    0.7.0.1
 */