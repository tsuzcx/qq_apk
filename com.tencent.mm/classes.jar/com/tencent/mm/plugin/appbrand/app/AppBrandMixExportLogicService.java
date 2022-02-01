package com.tencent.mm.plugin.appbrand.app;

import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.cn.g;
import com.tencent.mm.modelsimple.k;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest;
import com.tencent.mm.plugin.appbrand.u;
import com.tencent.mm.plugin.appbrand.ui.recommend.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class AppBrandMixExportLogicService
  implements com.tencent.mm.plugin.appbrand.service.f
{
  public static com.tencent.mm.vending.g.e<Pair<String, String>> w(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44098);
    paramString = g.j(paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)).b(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(44098);
    return paramString;
  }
  
  public final String Hx(String paramString)
  {
    AppMethodBeat.i(186286);
    paramString = u.Hx(paramString);
    AppMethodBeat.o(186286);
    return paramString;
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    AppMethodBeat.i(174698);
    OpenFileRequest localOpenFileRequest = new OpenFileRequest();
    localOpenFileRequest.filePath = paramString1;
    localOpenFileRequest.fBR = paramString2;
    localOpenFileRequest.appId = paramString3;
    localOpenFileRequest.jVr = paramBoolean;
    com.tencent.mm.plugin.appbrand.ipc.a.a(paramContext, localOpenFileRequest, paramString4);
    AppMethodBeat.o(174698);
  }
  
  public final <T extends Parcelable> void a(String paramString, T paramT)
  {
    AppMethodBeat.i(174695);
    com.tencent.mm.plugin.appbrand.ipc.e.b(paramString, paramT);
    AppMethodBeat.o(174695);
  }
  
  public final void aVd()
  {
    AppMethodBeat.i(44096);
    com.tencent.mm.plugin.appbrand.task.f.buA();
    AppMethodBeat.o(44096);
  }
  
  public final void aVe()
  {
    AppMethodBeat.i(44097);
    if ((c.bwQ()) && (c.bwS())) {
      com.tencent.mm.plugin.appbrand.task.f.buA();
    }
    h.JZN.aS(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44089);
        com.tencent.mm.plugin.appbrand.ui.recommend.d locald = com.tencent.mm.plugin.appbrand.ui.recommend.d.mmw;
        com.tencent.mm.plugin.appbrand.ui.recommend.d.bwT();
        AppMethodBeat.o(44089);
      }
    });
    AppMethodBeat.o(44097);
  }
  
  public final void aVf()
  {
    AppMethodBeat.i(186285);
    j.aSw();
    AppMethodBeat.o(186285);
  }
  
  public final Pair<String, Integer> ro(int paramInt)
  {
    AppMethodBeat.i(186287);
    Pair localPair = new Pair(com.tencent.mm.plugin.appbrand.appcache.e.rp(paramInt), Integer.valueOf(2131231009));
    AppMethodBeat.o(186287);
    return localPair;
  }
  
  public static final class AppBrandOnStartReportCanvasDataEvent
    implements Parcelable
  {
    public static final Parcelable.Creator<AppBrandOnStartReportCanvasDataEvent> CREATOR;
    public String appId;
    
    static
    {
      AppMethodBeat.i(44095);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(44095);
    }
    
    AppBrandOnStartReportCanvasDataEvent() {}
    
    AppBrandOnStartReportCanvasDataEvent(Parcel paramParcel)
    {
      AppMethodBeat.i(44094);
      this.appId = paramParcel.readString();
      AppMethodBeat.o(44094);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(44093);
      paramParcel.writeString(this.appId);
      AppMethodBeat.o(44093);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.AppBrandMixExportLogicService
 * JD-Core Version:    0.7.0.1
 */