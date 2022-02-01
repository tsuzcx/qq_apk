package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthConstants;", "()V", "Companion", "GetHeadIconPathCallback", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  private static final String TAG;
  public static final a rET;
  
  static
  {
    AppMethodBeat.i(50446);
    rET = new a((byte)0);
    TAG = "AuthorizeHelper";
    AppMethodBeat.o(50446);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper$Companion;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper;", "()V", "TAG", "", "getHeadIconPath", "", "username", "callback", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper$GetHeadIconPathCallback;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements f
  {
    private static final int a(com.tencent.mm.modelavatar.f paramf, h.b paramb, String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(326807);
      s.u(paramf, "$getHDHeadImgHelper");
      Log.i(h.access$getTAG$cp(), "GetHDHeadImg errType=%d  errCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramf.Qh();
      if (paramb != null)
      {
        q.bFp();
        paramString = AvatarStorage.Q(paramString, false);
        paramf = paramString;
        if (paramString == null) {
          paramf = "";
        }
        paramb.onCallback(paramf);
      }
      AppMethodBeat.o(326807);
      return 0;
    }
    
    public static void a(String paramString, h.b paramb)
    {
      AppMethodBeat.i(50445);
      Object localObject = (CharSequence)paramString;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          q.bFp();
          if (!AvatarStorage.S(paramString, false)) {
            break;
          }
        }
        q.bFp();
        localObject = paramString;
        if (paramString == null) {
          localObject = "";
        }
        localObject = AvatarStorage.Q((String)localObject, false);
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
        paramb.onCallback(paramString);
        AppMethodBeat.o(50445);
        return;
      }
      localObject = new com.tencent.mm.modelavatar.f();
      ((com.tencent.mm.modelavatar.f)localObject).a(paramString, new h.a..ExternalSyntheticLambda0((com.tencent.mm.modelavatar.f)localObject, paramb, paramString));
      AppMethodBeat.o(50445);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper$GetHeadIconPathCallback;", "", "onCallback", "", "path", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void onCallback(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.h
 * JD-Core Version:    0.7.0.1
 */