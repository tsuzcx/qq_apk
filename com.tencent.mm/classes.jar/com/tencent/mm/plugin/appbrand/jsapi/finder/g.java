package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import com.tencent.luggage.k.f;
import com.tencent.luggage.k.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.finder.ui.FinderAlbumUI;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.protocal.protobuf.FinderJsApiMediaObj;
import com.tencent.mm.protocal.protobuf.FinderJsApiMediaThumbInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g
  extends c
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "openFinderPostPicker";
  
  public final void a(final e parame, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(163961);
    if (!(parame.getContext() instanceof Activity))
    {
      parame.j(paramInt, "fail");
      AppMethodBeat.o(163961);
      return;
    }
    paramJSONObject = new Intent(parame.getContext(), FinderAlbumUI.class);
    paramJSONObject.addFlags(67108864);
    paramJSONObject.putExtra("key_can_select_video_and_pic", true);
    paramJSONObject.putExtra("is_hide_album_footer", true);
    paramJSONObject.putExtra("show_header_view", false);
    paramJSONObject.putExtra("max_select_count", 9);
    paramJSONObject.putExtra("query_source_type", 25);
    paramJSONObject.putExtra("query_media_type", 3);
    paramJSONObject.putExtra("fromAppBrand", true);
    f.aI(parame.getContext()).a(paramJSONObject, new f.b()
    {
      public final void a(int paramAnonymousInt, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(163960);
        JSONArray localJSONArray = new JSONArray();
        if (paramAnonymousInt == -1)
        {
          paramAnonymousInt = paramAnonymousIntent.getIntExtra("postType", 0);
          ArrayList localArrayList1 = paramAnonymousIntent.getStringArrayListExtra("postMediaList");
          paramAnonymousIntent = paramAnonymousIntent.getStringArrayListExtra("postThumbList");
          Log.i("MicroMsg.Finder.JsApiOpenFinderPostPicker", "receive mediaType: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          Log.i("MicroMsg.Finder.JsApiOpenFinderPostPicker", "receive mediaPath: %s", new Object[] { localArrayList1 });
          Log.i("MicroMsg.Finder.JsApiOpenFinderPostPicker", "receive thumbPath: %s", new Object[] { paramAnonymousIntent });
          ArrayList localArrayList2 = new ArrayList();
          paramAnonymousInt = 0;
          if (paramAnonymousInt < localArrayList1.size())
          {
            Object localObject1 = new i();
            FinderJsApiMediaObj localFinderJsApiMediaObj = new FinderJsApiMediaObj();
            Object localObject2 = parame.getFileSystem().a(new q((String)localArrayList1.get(paramAnonymousInt)), null, false, (i)localObject1);
            m localm;
            if (localObject2 == m.nMR)
            {
              localFinderJsApiMediaObj.mediaPath = ((String)((i)localObject1).value);
              if (localFinderJsApiMediaObj.mediaType == 2)
              {
                localFinderJsApiMediaObj.thumbInfo = new FinderJsApiMediaThumbInfo();
                localObject2 = (String)paramAnonymousIntent.get(paramAnonymousInt);
                localm = parame.getFileSystem().a(new q((String)localObject2), null, false, (i)localObject1);
                if (localm == m.nMR)
                {
                  localFinderJsApiMediaObj.thumbInfo.thumbPath = ((String)((i)localObject1).value);
                  localObject1 = aj.AGc;
                  localObject1 = aj.aFH((String)localObject2);
                  localFinderJsApiMediaObj.thumbInfo.thumbWidth = ((Point)localObject1).x;
                  localFinderJsApiMediaObj.thumbInfo.thumbHeight = ((Point)localObject1).y;
                  localArrayList2.add(localFinderJsApiMediaObj);
                }
              }
            }
            for (;;)
            {
              paramAnonymousInt += 1;
              break;
              Log.i("MicroMsg.Finder.JsApiOpenFinderPostPicker", "create thumb media file error %s %s %b %d", new Object[] { localm.name(), localObject2, Boolean.valueOf(u.agG((String)localObject2)), Long.valueOf(u.bBQ((String)localObject2)) });
              continue;
              if (localFinderJsApiMediaObj.mediaType == 4)
              {
                localFinderJsApiMediaObj.thumbInfo = new FinderJsApiMediaThumbInfo();
                localObject2 = (String)paramAnonymousIntent.get(paramAnonymousInt);
                localm = parame.getFileSystem().a(new q((String)localObject2), null, false, (i)localObject1);
                if (localm == m.nMR)
                {
                  localFinderJsApiMediaObj.thumbInfo.thumbPath = ((String)((i)localObject1).value);
                  localObject1 = aj.AGc;
                  localObject1 = aj.aFG((String)localObject2);
                  if (localObject1 != null)
                  {
                    localFinderJsApiMediaObj.thumbInfo.thumbWidth = ((b)localObject1).width;
                    localFinderJsApiMediaObj.thumbInfo.thumbHeight = ((b)localObject1).height;
                  }
                  localArrayList2.add(localFinderJsApiMediaObj);
                }
                else
                {
                  Log.i("MicroMsg.Finder.JsApiOpenFinderPostPicker", "create thumb media file error %s %s %b %d", new Object[] { localm.name(), localObject2, Boolean.valueOf(u.agG((String)localObject2)), Long.valueOf(u.bBQ((String)localObject2)) });
                  continue;
                  Log.i("MicroMsg.Finder.JsApiOpenFinderPostPicker", "create media file error %s %s", new Object[] { ((m)localObject2).name(), localArrayList1.get(paramAnonymousInt) });
                }
              }
            }
          }
          if (localArrayList2.size() > 0) {
            try
            {
              a.b(localArrayList2, localJSONArray);
              paramAnonymousIntent = a.a("", 0, localJSONArray);
              Log.i("MicroMsg.Finder.JsApiOpenFinderPostPicker", "returnRetMsg %s", new Object[] { paramAnonymousIntent });
              parame.j(paramInt, paramAnonymousIntent);
              AppMethodBeat.o(163960);
              return;
            }
            catch (Exception paramAnonymousIntent)
            {
              Log.printErrStackTrace("MicroMsg.Finder.JsApiOpenFinderPostPicker", paramAnonymousIntent, "JsApiOpenFinderImagePickerController", new Object[0]);
              parame.j(paramInt, a.a(paramAnonymousIntent.getMessage(), -1, localJSONArray));
              AppMethodBeat.o(163960);
              return;
            }
          }
          parame.j(paramInt, a.a("not select media", -1, localJSONArray));
          AppMethodBeat.o(163960);
          return;
        }
        parame.j(paramInt, a.a("cancel select media", -1, localJSONArray));
        AppMethodBeat.o(163960);
      }
    });
    AppMethodBeat.o(163961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.g
 * JD-Core Version:    0.7.0.1
 */