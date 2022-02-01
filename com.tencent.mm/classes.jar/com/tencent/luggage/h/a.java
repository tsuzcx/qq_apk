package com.tencent.luggage.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.skyline.SkylineLogic;
import io.flutter.embedding.android.FlutterView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/skyline/FlutterViewManager;", "", "()V", "CACHE_COUNT", "", "currentCount", "sFlutterViews", "Ljava/util/ArrayList;", "Lio/flutter/embedding/android/FlutterView;", "Lkotlin/collections/ArrayList;", "sInit", "", "init", "", "context", "Landroid/content/Context;", "isTextureView", "obtain", "uninit", "luggage-skyline-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a evR;
  private static final int evS;
  private static ArrayList<FlutterView> evT;
  private static int evU;
  private static boolean sInit;
  
  static
  {
    AppMethodBeat.i(219982);
    evR = new a();
    evS = 2;
    evT = new ArrayList(evS);
    AppMethodBeat.o(219982);
  }
  
  public final FlutterView asR()
  {
    ViewParent localViewParent;
    try
    {
      AppMethodBeat.i(219995);
      Object localObject = evT.get(evU % evS);
      s.s(localObject, "sFlutterViews[currentCount % CACHE_COUNT]");
      localObject = (FlutterView)localObject;
      evU += 1;
      if (((FlutterView)localObject).getParent() == null) {
        break label96;
      }
      SkylineLogic.INSTANCE.detachFlutterView((FlutterView)localObject);
      localViewParent = ((FlutterView)localObject).getParent();
      if (localViewParent == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(219995);
        throw ((Throwable)localObject);
      }
    }
    finally {}
    ((ViewGroup)localViewParent).removeView((View)localFlutterView);
    label96:
    AppMethodBeat.o(219995);
    return localFlutterView;
  }
  
  public final void init(Context paramContext, boolean paramBoolean)
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(219987);
        s.u(paramContext, "context");
        if (sInit)
        {
          AppMethodBeat.o(219987);
          return;
        }
        sInit = true;
        int j = evS;
        if (j > 0)
        {
          i = 1;
          ArrayList localArrayList = evT;
          if (paramBoolean)
          {
            localFlutterView = SkylineLogic.createFlutterView$default(SkylineLogic.INSTANCE, paramContext, 0, 0, 1, 6, null);
            localArrayList.add(localFlutterView);
            if (i != j) {
              break label112;
            }
          }
        }
        else
        {
          AppMethodBeat.o(219987);
          continue;
        }
        FlutterView localFlutterView = SkylineLogic.createFlutterView$default(SkylineLogic.INSTANCE, paramContext, 0, 0, 2, 6, null);
      }
      finally {}
      continue;
      label112:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.h.a
 * JD-Core Version:    0.7.0.1
 */