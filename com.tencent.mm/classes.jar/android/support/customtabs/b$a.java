package android.support.customtabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.c;
import java.util.ArrayList;

public final class b$a
{
  public ArrayList<Bundle> dA = null;
  public Bundle dB = null;
  public ArrayList<Bundle> dC = null;
  public boolean dD = true;
  public final Intent mIntent = new Intent("android.intent.action.VIEW");
  
  public b$a()
  {
    this((byte)0);
  }
  
  private b$a(byte paramByte)
  {
    Bundle localBundle = new Bundle();
    c.a(localBundle, "android.support.customtabs.extra.SESSION", null);
    this.mIntent.putExtras(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.customtabs.b.a
 * JD-Core Version:    0.7.0.1
 */