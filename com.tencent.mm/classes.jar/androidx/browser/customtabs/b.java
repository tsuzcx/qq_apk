package androidx.browser.customtabs;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class b
{
  public final Intent intent;
  public final Bundle yq;
  
  public b(Intent paramIntent, Bundle paramBundle)
  {
    this.intent = paramIntent;
    this.yq = paramBundle;
  }
  
  public static final class a
  {
    public final Intent mIntent;
    public ArrayList<Bundle> yr;
    public Bundle ys;
    public ArrayList<Bundle> yt;
    public boolean yu;
    
    public a()
    {
      this((byte)0);
    }
    
    private a(byte paramByte)
    {
      AppMethodBeat.i(191288);
      this.mIntent = new Intent("android.intent.action.VIEW");
      this.yr = null;
      this.ys = null;
      this.yt = null;
      this.yu = true;
      Bundle localBundle = new Bundle();
      androidx.core.app.b.a(localBundle, "android.support.customtabs.extra.SESSION", null);
      this.mIntent.putExtras(localBundle);
      AppMethodBeat.o(191288);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.browser.customtabs.b
 * JD-Core Version:    0.7.0.1
 */