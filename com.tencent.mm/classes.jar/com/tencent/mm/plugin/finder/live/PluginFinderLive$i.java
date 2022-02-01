package com.tencent.mm.plugin.finder.live;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.search.k;
import com.tencent.mm.plugin.findersdk.a.t;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.azf;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bix;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.a.g.a;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/PluginFinderLive$checkLastLiveObject$1$1", "Lcom/tencent/mm/plugin/findersdk/api/ICgiFinderLiveGetLastObjectCallback;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLatestLiveObjectResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginFinderLive$i
  implements t
{
  PluginFinderLive$i(long paramLong, b<? super Boolean, ah> paramb, ah.a parama, Context paramContext, PluginFinderLive paramPluginFinderLive) {}
  
  private static final void a(FinderObject paramFinderObject, PluginFinderLive paramPluginFinderLive, Context paramContext, bip parambip, b paramb, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(350857);
    s.u(paramPluginFinderLive, "this$0");
    s.u(parambip, "$it");
    Object localObject;
    label104:
    long l1;
    long l2;
    if (paramFinderObject == null)
    {
      paramString = null;
      localObject = paramFinderObject.liveInfo;
      if (localObject != null)
      {
        int i = ((bip)localObject).ZFJ;
        if (paramString != null) {
          paramString.putExtra("KEY_PARAMS_SOURCE_TYPE", i);
        }
      }
      localObject = paramFinderObject.liveInfo;
      if (localObject != null)
      {
        localObject = ((bip)localObject).Idh;
        if ((localObject != null) && (paramString != null)) {
          paramString.putExtra("KEY_PARAMS_GAME_APP_ID", (String)localObject);
        }
      }
      if (paramContext != null) {
        break label253;
      }
      localObject = MMApplicationContext.getContext();
      l1 = paramFinderObject.id;
      l2 = parambip.liveId;
      paramContext = paramFinderObject.objectNonceId;
      parambip = paramContext;
      if (paramContext == null) {
        parambip = "";
      }
      paramContext = k.FxZ;
      paramContext = paramFinderObject.objectDesc;
      if (paramContext != null) {
        break label259;
      }
      paramContext = "";
    }
    for (;;)
    {
      paramPluginFinderLive.enterFinderLiveAnchorUI(paramString, (Context)localObject, l1, Long.valueOf(l2), parambip, k.Sp(paramContext), "", paramFinderObject.sessionBuffer, "");
      if (paramb != null) {
        paramb.invoke(Boolean.TRUE);
      }
      AppMethodBeat.o(350857);
      return;
      paramString = paramFinderObject.liveInfo;
      if (paramString == null)
      {
        paramString = null;
        break;
      }
      paramString = paramString.ZRZ;
      if (paramString == null)
      {
        paramString = null;
        break;
      }
      paramString = new Intent().putExtra("KEY_PARAMS_LAYER_SHOW_INFO", paramString.toByteArray());
      break;
      label253:
      localObject = paramContext;
      break label104;
      label259:
      String str = paramContext.description;
      paramContext = str;
      if (str == null) {
        paramContext = "";
      }
    }
  }
  
  private static final void a(b paramb, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(350863);
    if (paramb != null) {
      paramb.invoke(Boolean.FALSE);
    }
    AppMethodBeat.o(350863);
  }
  
  public final void a(int paramInt1, int paramInt2, azf paramazf)
  {
    AppMethodBeat.i(350888);
    s.u(paramazf, "resp");
    long l = System.currentTimeMillis() - this.qIR;
    FinderObject localFinderObject = paramazf.ZIo;
    Object localObject = new StringBuilder("checkUnfinishLive duration:").append(l).append(" finderObject:[objectId:");
    if (localFinderObject == null)
    {
      paramazf = null;
      localObject = ((StringBuilder)localObject).append(paramazf).append(" liveId:");
      if (localFinderObject != null) {
        break label202;
      }
      paramazf = null;
      label75:
      localObject = ((StringBuilder)localObject).append(paramazf).append(" anchorUsername:");
      if (localFinderObject != null) {
        break label228;
      }
      paramazf = null;
      label95:
      localObject = ((StringBuilder)localObject).append(paramazf).append(" liveStatus:");
      if (localFinderObject != null) {
        break label251;
      }
      paramazf = null;
      label115:
      localObject = ((StringBuilder)localObject).append(paramazf).append(" layerInfoType:");
      if (localFinderObject != null) {
        break label277;
      }
      paramazf = null;
      label135:
      Log.i("Plugin.FinderLive", paramazf + ']');
      if (localFinderObject != null) {
        break label317;
      }
      paramazf = null;
    }
    for (;;)
    {
      if (paramazf == null)
      {
        paramazf = this.$callback;
        if (paramazf != null) {
          paramazf.invoke(Boolean.FALSE);
        }
      }
      AppMethodBeat.o(350888);
      return;
      paramazf = Long.valueOf(localFinderObject.id);
      break;
      label202:
      paramazf = localFinderObject.liveInfo;
      if (paramazf == null)
      {
        paramazf = null;
        break label75;
      }
      paramazf = Long.valueOf(paramazf.liveId);
      break label75;
      label228:
      paramazf = localFinderObject.contact;
      if (paramazf == null)
      {
        paramazf = null;
        break label95;
      }
      paramazf = paramazf.username;
      break label95;
      label251:
      paramazf = localFinderObject.liveInfo;
      if (paramazf == null)
      {
        paramazf = null;
        break label115;
      }
      paramazf = Integer.valueOf(paramazf.liveStatus);
      break label115;
      label277:
      paramazf = localFinderObject.liveInfo;
      if (paramazf == null)
      {
        paramazf = null;
        break label135;
      }
      paramazf = paramazf.ZRZ;
      if (paramazf == null)
      {
        paramazf = null;
        break label135;
      }
      paramazf = Integer.valueOf(paramazf.show_type);
      break label135;
      label317:
      paramazf = localFinderObject.liveInfo;
      if (paramazf == null)
      {
        paramazf = null;
      }
      else
      {
        localObject = this.Byp;
        Context localContext = this.$context;
        b localb = this.$callback;
        PluginFinderLive localPluginFinderLive = this.Byh;
        if (l < 5000L)
        {
          if (paramazf.liveStatus == 1) {}
          for (boolean bool = true;; bool = false)
          {
            ((ah.a)localObject).aiwY = bool;
            Log.i("Plugin.FinderLive", s.X("checkUnfinishLive remoteUnfinishLive:", Boolean.valueOf(((ah.a)localObject).aiwY)));
            if (!((ah.a)localObject).aiwY) {
              break label511;
            }
            new g.a(localContext).bDE(MMApplicationContext.getContext().getResources().getString(p.h.CkZ)).bDI(MMApplicationContext.getContext().getResources().getString(p.h.CkY)).b(new PluginFinderLive.i..ExternalSyntheticLambda0(localFinderObject, localPluginFinderLive, localContext, paramazf, localb)).bDJ(MMApplicationContext.getContext().getResources().getString(p.h.app_cancel)).a(new PluginFinderLive.i..ExternalSyntheticLambda1(localb)).show();
            paramazf = ah.aiuX;
            break;
          }
          label511:
          if (localb == null)
          {
            paramazf = null;
          }
          else
          {
            localb.invoke(Boolean.FALSE);
            paramazf = ah.aiuX;
          }
        }
        else
        {
          if (localb != null) {
            localb.invoke(Boolean.FALSE);
          }
          Log.i("Plugin.FinderLive", s.X("checkUnfinishLive timeout: duration:", Long.valueOf(l)));
          paramazf = ah.aiuX;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.PluginFinderLive.i
 * JD-Core Version:    0.7.0.1
 */