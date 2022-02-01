package com.tencent.mm.plugin.gallery.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.gallery.b.i;
import com.tencent.mm.ui.widget.a.g.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/utils/AlbumSelectRestrictionDialogFactory;", "", "()V", "ALBUM_RESTRICTION_DURATION_ERROR", "", "ALBUM_RESTRICTION_DURATION_LONG_ERROR", "ALBUM_RESTRICTION_DURATION_SHORT_ERROR", "ALBUM_RESTRICTION_FORMAT_AUDIO_MIME_ERROR", "ALBUM_RESTRICTION_FORMAT_ERROR", "ALBUM_RESTRICTION_FORMAT_FILE_FORMAT_ERROR", "ALBUM_RESTRICTION_FORMAT_QT_ERROR", "ALBUM_RESTRICTION_FORMAT_SUFFIX_ERROR", "ALBUM_RESTRICTION_FORMAT_VIDEO_MIME_ERROR", "ALBUM_RESTRICTION_OK", "ALBUM_RESTRICTION_RATIO_ERROR", "ALBUM_RESTRICTION_RATIO_LONG_SIDE_ERROR", "ALBUM_RESTRICTION_RATIO_MAX_ERROR", "ALBUM_RESTRICTION_RATIO_MIN_ERROR", "ALBUM_RESTRICTION_RATIO_SHORT_SIDE_ERROR", "showAlbumSelectRestrictionDialog", "", "context", "Landroid/content/Context;", "errorCode", "scene", "showNotSupportFormatDialog", "showNotSupportRatioDialog", "showTimeNotSupportDialog", "durationMs", "showTimeNotSupportDialogByScene", "showTimeTooShortDialog", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c HRd;
  
  static
  {
    AppMethodBeat.i(289306);
    HRd = new c();
    AppMethodBeat.o(289306);
  }
  
  private static final void aj(boolean paramBoolean, String paramString) {}
  
  private static final void ak(boolean paramBoolean, String paramString) {}
  
  private static final void al(boolean paramBoolean, String paramString) {}
  
  private static final void am(boolean paramBoolean, String paramString) {}
  
  public static void j(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(289284);
    s.u(paramContext, "context");
    Object localObject;
    if (paramInt1 < 200)
    {
      localObject = new g.a(paramContext);
      ((g.a)localObject).bf((CharSequence)a.bt(paramContext, b.i.gallery_pic_video_not_support_desc));
      ((g.a)localObject).bDI(a.bt(paramContext, b.i.gallery_i_know));
      ((g.a)localObject).b(c..ExternalSyntheticLambda1.INSTANCE);
      ((g.a)localObject).show();
      AppMethodBeat.o(289284);
      return;
    }
    String str;
    if (paramInt1 == 201)
    {
      localObject = b.HQZ;
      paramInt1 = b.WV(paramInt2);
      localObject = new g.a(paramContext);
      str = paramContext.getString(b.i.gallery_pic_video_too_short_desc_custom, new Object[] { Integer.valueOf(paramInt1 / 1000) });
      s.s(str, "context.getString(R.stri…sc_custom, timeMS / 1000)");
      ((g.a)localObject).bf((CharSequence)str);
      ((g.a)localObject).bDI(a.bt(paramContext, b.i.gallery_i_know));
      ((g.a)localObject).b(c..ExternalSyntheticLambda3.INSTANCE);
      ((g.a)localObject).show();
      AppMethodBeat.o(289284);
      return;
    }
    if (paramInt1 < 300)
    {
      localObject = b.HQZ;
      paramInt1 = b.WU(paramInt2);
      localObject = new g.a(paramContext);
      str = paramContext.getString(b.i.gallery_pic_video_too_long_custom_desc, new Object[] { Integer.valueOf(paramInt1 / 1000 / 60) });
      s.s(str, "context.getString(R.stri…, durationMs / 1000 / 60)");
      ((g.a)localObject).bf((CharSequence)str);
      ((g.a)localObject).bDI(a.bt(paramContext, b.i.gallery_i_know));
      ((g.a)localObject).b(c..ExternalSyntheticLambda2.INSTANCE);
      ((g.a)localObject).show();
      AppMethodBeat.o(289284);
      return;
    }
    if (paramInt1 < 400)
    {
      localObject = new g.a(paramContext);
      ((g.a)localObject).bf((CharSequence)a.bt(paramContext, b.i.gallery_pic_video_special_ratio_desc));
      ((g.a)localObject).bDI(a.bt(paramContext, b.i.gallery_i_know));
      ((g.a)localObject).b(c..ExternalSyntheticLambda0.INSTANCE);
      ((g.a)localObject).show();
      AppMethodBeat.o(289284);
      return;
    }
    AppMethodBeat.o(289284);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.b.c
 * JD-Core Version:    0.7.0.1
 */