package com.tencent.liteapp.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.android.i;
import io.flutter.embedding.android.l;
import java.lang.reflect.Constructor;

public final class WxaLiteAppBaseFragment$a
{
  private String appId;
  private final Class<? extends WxaLiteAppBaseFragment> cpi;
  private i cpj = i.aapM;
  private l cpk = l.aapR;
  private boolean cpl = true;
  private String cpm;
  private String query;
  
  public WxaLiteAppBaseFragment$a()
  {
    this.cpi = WxaLiteAppBaseFragment.class;
  }
  
  public WxaLiteAppBaseFragment$a(Class<? extends WxaLiteAppBaseFragment> paramClass)
  {
    this.cpi = paramClass;
  }
  
  public final <T extends WxaLiteAppBaseFragment> T NH()
  {
    AppMethodBeat.i(258552);
    WxaLiteAppBaseFragment localWxaLiteAppBaseFragment;
    try
    {
      localWxaLiteAppBaseFragment = (WxaLiteAppBaseFragment)this.cpi.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      if (localWxaLiteAppBaseFragment == null)
      {
        RuntimeException localRuntimeException = new RuntimeException("The FlutterFragment subclass sent in the constructor (" + this.cpi.getCanonicalName() + ") does not match the expected return type.");
        AppMethodBeat.o(258552);
        throw localRuntimeException;
      }
    }
    catch (Exception localException)
    {
      localObject = new RuntimeException("Could not instantiate FlutterFragment subclass (" + this.cpi.getName() + ")", localException);
      AppMethodBeat.o(258552);
      throw ((Throwable)localObject);
    }
    Bundle localBundle = new Bundle();
    if (this.cpj != null)
    {
      localObject = this.cpj.name();
      localBundle.putString("flutterview_render_mode", (String)localObject);
      if (this.cpk == null) {
        break label259;
      }
    }
    label259:
    for (Object localObject = this.cpk.name();; localObject = l.aapR.name())
    {
      localBundle.putString("flutterview_transparency_mode", (String)localObject);
      localBundle.putBoolean("should_attach_engine_to_activity", this.cpl);
      localBundle.putBoolean("destroy_engine_with_fragment", true);
      if (this.appId != null) {
        localBundle.putString("LiteAppId", this.appId);
      }
      if (this.cpm != null) {
        localBundle.putString("page", this.cpm);
      }
      if (this.query != null) {
        localBundle.putString("query", this.query);
      }
      localWxaLiteAppBaseFragment.setArguments(localBundle);
      AppMethodBeat.o(258552);
      return localWxaLiteAppBaseFragment;
      localObject = i.aapM.name();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteapp.ui.WxaLiteAppBaseFragment.a
 * JD-Core Version:    0.7.0.1
 */