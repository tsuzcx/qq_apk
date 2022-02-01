package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import com.tencent.luggage.h.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.finder.ui.FinderAlbumUI;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderJsApiMediaObj;
import com.tencent.mm.protocal.protobuf.FinderJsApiMediaThumbInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g
  extends d
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "openFinderPostPicker";
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(163961);
    if (!(paramf.getContext() instanceof Activity))
    {
      paramf.i(paramInt, "fail");
      AppMethodBeat.o(163961);
      return;
    }
    paramJSONObject = new Intent(paramf.getContext(), FinderAlbumUI.class);
    paramJSONObject.addFlags(67108864);
    paramJSONObject.putExtra("key_can_select_video_and_pic", true);
    paramJSONObject.putExtra("is_hide_album_footer", true);
    paramJSONObject.putExtra("show_header_view", false);
    paramJSONObject.putExtra("max_select_count", 9);
    paramJSONObject.putExtra("query_source_type", 25);
    paramJSONObject.putExtra("query_media_type", 3);
    paramJSONObject.putExtra("fromAppBrand", true);
    com.tencent.luggage.h.f.aK(paramf.getContext()).a(paramJSONObject, new f.b()
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
            Object localObject2 = paramf.getFileSystem().a(new o((String)localArrayList1.get(paramAnonymousInt)), null, false, (i)localObject1);
            m localm;
            if (localObject2 == m.kSu)
            {
              localFinderJsApiMediaObj.mediaPath = ((String)((i)localObject1).value);
              if (localFinderJsApiMediaObj.mediaType == 2)
              {
                localFinderJsApiMediaObj.thumbInfo = new FinderJsApiMediaThumbInfo();
                localObject2 = (String)paramAnonymousIntent.get(paramAnonymousInt);
                localm = paramf.getFileSystem().a(new o((String)localObject2), null, false, (i)localObject1);
                if (localm == m.kSu)
                {
                  localFinderJsApiMediaObj.thumbInfo.thumbPath = ((String)((i)localObject1).value);
                  localObject1 = y.vXH;
                  localObject1 = y.awm((String)localObject2);
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
              Log.i("MicroMsg.Finder.JsApiOpenFinderPostPicker", "create thumb media file error %s %s %b %d", new Object[] { localm.name(), localObject2, Boolean.valueOf(s.YS((String)localObject2)), Long.valueOf(s.boW((String)localObject2)) });
              continue;
              if (localFinderJsApiMediaObj.mediaType == 4)
              {
                localFinderJsApiMediaObj.thumbInfo = new FinderJsApiMediaThumbInfo();
                localObject2 = (String)paramAnonymousIntent.get(paramAnonymousInt);
                localm = paramf.getFileSystem().a(new o((String)localObject2), null, false, (i)localObject1);
                if (localm == m.kSu)
                {
                  localFinderJsApiMediaObj.thumbInfo.thumbPath = ((String)((i)localObject1).value);
                  localObject1 = y.vXH;
                  localObject1 = y.awl((String)localObject2);
                  if (localObject1 != null)
                  {
                    localFinderJsApiMediaObj.thumbInfo.thumbWidth = ((com.tencent.mm.plugin.sight.base.a)localObject1).width;
                    localFinderJsApiMediaObj.thumbInfo.thumbHeight = ((com.tencent.mm.plugin.sight.base.a)localObject1).height;
                  }
                  localArrayList2.add(localFinderJsApiMediaObj);
                }
                else
                {
                  Log.i("MicroMsg.Finder.JsApiOpenFinderPostPicker", "create thumb media file error %s %s %b %d", new Object[] { localm.name(), localObject2, Boolean.valueOf(s.YS((String)localObject2)), Long.valueOf(s.boW((String)localObject2)) });
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
              paramf.i(paramInt, paramAnonymousIntent);
              AppMethodBeat.o(163960);
              return;
            }
            catch (Exception paramAnonymousIntent)
            {
              Log.printErrStackTrace("MicroMsg.Finder.JsApiOpenFinderPostPicker", paramAnonymousIntent, "JsApiOpenFinderImagePickerController", new Object[0]);
              paramf.i(paramInt, a.a(paramAnonymousIntent.getMessage(), -1, localJSONArray));
              AppMethodBeat.o(163960);
              return;
            }
          }
          paramf.i(paramInt, a.a("not select media", -1, localJSONArray));
          AppMethodBeat.o(163960);
          return;
        }
        paramf.i(paramInt, a.a("cancel select media", -1, localJSONArray));
        AppMethodBeat.o(163960);
      }
    });
    AppMethodBeat.o(163961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.g
 * JD-Core Version:    0.7.0.1
 */