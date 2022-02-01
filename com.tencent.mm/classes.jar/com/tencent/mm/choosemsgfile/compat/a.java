package com.tencent.mm.choosemsgfile.compat;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public abstract interface a
  extends com.tencent.mm.kernel.c.a
{
  public abstract void a(Activity paramActivity, String paramString1, int paramInt, String paramString2, a parama);
  
  public abstract void a(MMActivity paramMMActivity, String paramString1, String paramString2, int paramInt, String paramString3, a parama);
  
  public abstract void g(Context paramContext, String paramString1, String paramString2);
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, String paramString, ArrayList<MsgFile> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.choosemsgfile.compat.a
 * JD-Core Version:    0.7.0.1
 */