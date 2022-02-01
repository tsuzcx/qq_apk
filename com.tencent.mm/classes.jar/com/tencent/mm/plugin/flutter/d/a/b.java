package com.tencent.mm.plugin.flutter.d.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/plugins/platform/PlatformPagViewFactory;", "Lio/flutter/plugin/platform/PlatformViewFactory;", "messenger", "Lio/flutter/plugin/common/BinaryMessenger;", "(Lio/flutter/plugin/common/BinaryMessenger;)V", "channel", "Lio/flutter/plugin/common/MethodChannel;", "create", "Lio/flutter/plugin/platform/PlatformView;", "context", "Landroid/content/Context;", "id", "", "args", "", "plugin-flutter_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends PlatformViewFactory
{
  private MethodChannel channel;
  private final BinaryMessenger messenger;
  
  public b(BinaryMessenger paramBinaryMessenger)
  {
    super((MessageCodec)StandardMessageCodec.INSTANCE);
    AppMethodBeat.i(263164);
    this.messenger = paramBinaryMessenger;
    AppMethodBeat.o(263164);
  }
  
  public final PlatformView create(Context paramContext, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(263179);
    Map localMap = (Map)paramObject;
    paramObject = this.messenger;
    Object localObject = am.aixg;
    localObject = String.format("wx_platformview_%d", Arrays.copyOf(new Object[] { Integer.valueOf(paramInt) }, 1));
    s.s(localObject, "java.lang.String.format(format, *args)");
    this.channel = new MethodChannel(paramObject, (String)localObject);
    localObject = this.channel;
    paramObject = localObject;
    if (localObject == null)
    {
      s.bIx("channel");
      paramObject = null;
    }
    paramContext = (PlatformView)new a(paramContext, localMap, paramObject);
    AppMethodBeat.o(263179);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.d.a.b
 * JD-Core Version:    0.7.0.1
 */