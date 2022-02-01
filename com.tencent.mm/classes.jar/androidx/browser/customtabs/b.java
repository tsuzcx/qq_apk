package androidx.browser.customtabs;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class b
{
  public final Intent intent;
  public final Bundle zl;
  
  public b(Intent paramIntent, Bundle paramBundle)
  {
    this.intent = paramIntent;
    this.zl = paramBundle;
  }
  
  public static final class a
  {
    public final Intent mIntent;
    public ArrayList<Bundle> zm;
    public Bundle zn;
    public ArrayList<Bundle> zo;
    public boolean zp;
    
    public a()
    {
      this((byte)0);
    }
    
    public a(byte paramByte)
    {
      AppMethodBeat.i(192966);
      this.mIntent = new Intent("android.intent.action.VIEW");
      this.zm = null;
      this.zn = null;
      this.zo = null;
      this.zp = true;
      Bundle localBundle = new Bundle();
      c.a(localBundle, "android.support.customtabs.extra.SESSION", null);
      this.mIntent.putExtras(localBundle);
      AppMethodBeat.o(192966);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.browser.customtabs.b
 * JD-Core Version:    0.7.0.1
 */