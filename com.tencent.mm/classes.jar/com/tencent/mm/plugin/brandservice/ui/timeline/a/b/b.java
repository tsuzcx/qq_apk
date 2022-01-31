package com.tencent.mm.plugin.brandservice.ui.timeline.a.b;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.f;

public final class b
  implements com.tencent.mm.plugin.brandservice.a.b
{
  public final void a(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString1);
    localBundle.putInt("aScene", paramInt1);
    localBundle.putString("sessionId", paramString2);
    localBundle.putInt("scene", paramInt2);
    localBundle.putInt("subScene", paramInt3);
    f.a("com.tencent.mm", localBundle, b.b.class, null);
  }
  
  public final void axr()
  {
    f.a("com.tencent.mm", null, b.a.class, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.b.b
 * JD-Core Version:    0.7.0.1
 */