package com.tencent.mm.plugin.fav.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.applet.y.a;

public abstract interface ab
  extends a
{
  public abstract int Yn(String paramString);
  
  public abstract int a(k.b paramb, WXMediaMessage paramWXMediaMessage, String paramString);
  
  public abstract int a(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3);
  
  public abstract void a(Context paramContext, String paramString, g paramg, boolean paramBoolean, y.a parama);
  
  public abstract void b(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void b(Activity paramActivity, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ab
 * JD-Core Version:    0.7.0.1
 */