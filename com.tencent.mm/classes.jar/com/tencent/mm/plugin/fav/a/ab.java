package com.tencent.mm.plugin.fav.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.af.j.b;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

public abstract interface ab
  extends a
{
  public abstract int NS(String paramString);
  
  public abstract int a(j.b paramb, WXMediaMessage paramWXMediaMessage, String paramString);
  
  public abstract int a(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3);
  
  public abstract void a(Activity paramActivity, String paramString1, String paramString2);
  
  public abstract void a(Context paramContext, String paramString, g paramg, boolean paramBoolean, q.a parama);
  
  public abstract void b(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ab
 * JD-Core Version:    0.7.0.1
 */