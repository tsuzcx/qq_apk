package android.support.customtabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.c;
import java.util.ArrayList;

public final class b
{
  public final Bundle dA;
  public final Intent intent;
  
  private b(Intent paramIntent, Bundle paramBundle)
  {
    this.intent = paramIntent;
    this.dA = paramBundle;
  }
  
  public static final class a
  {
    public ArrayList<Bundle> dB = null;
    public Bundle dC = null;
    public ArrayList<Bundle> dD = null;
    public boolean dE = true;
    public final Intent mIntent = new Intent("android.intent.action.VIEW");
    
    public a()
    {
      this((byte)0);
    }
    
    private a(byte paramByte)
    {
      Bundle localBundle = new Bundle();
      c.a(localBundle, "android.support.customtabs.extra.SESSION", null);
      this.mIntent.putExtras(localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.customtabs.b
 * JD-Core Version:    0.7.0.1
 */