package com.tencent.mm.plugin.finder.uniComments.util;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.dtj;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/util/UniConvertUtil;", "", "()V", "getCoverURL", "", "bytes", "", "jumpToMusic", "", "ref_comment_id", "", "entity_id", "context", "Landroid/content/Context;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Gbq;
  
  static
  {
    AppMethodBeat.i(341487);
    Gbq = new a();
    AppMethodBeat.o(341487);
  }
  
  public static void a(byte[] paramArrayOfByte, long paramLong, String paramString, Context paramContext)
  {
    AppMethodBeat.i(341481);
    s.u(paramArrayOfByte, "bytes");
    s.u(paramString, "entity_id");
    s.u(paramContext, "context");
    try
    {
      boo localboo = new boo();
      localboo.parseFrom(paramArrayOfByte);
      dtj localdtj = new dtj();
      Intent localIntent = new Intent();
      localIntent.putExtra("key_mv_cover_url", localboo.ZWS);
      localIntent.putExtra("key_launch_mv_comment", true);
      localIntent.putExtra("key_refer_mv_comment_id", paramLong);
      localIntent.putExtra("key_need_update_music_ball_url", true);
      localIntent.putExtra("key_mv_extra_info", localboo.extraInfo);
      localIntent.putExtra("key_mv_identification", localboo.identification);
      localIntent.putExtra("key_mv_music_duration", localboo.duration);
      localIntent.putExtra("key_mv_song_mid", localboo.oOZ);
      localdtj.YqP = localboo.ZWS;
      localdtj.singerName = localboo.rDl;
      localdtj.albumName = localboo.albumName;
      localdtj.extraInfo = localboo.extraInfo;
      localdtj.musicGenre = localboo.ZTA;
      localdtj.identification = localboo.identification;
      localdtj.LNC = localboo.duration;
      localdtj.songName = localboo.songName;
      localdtj.songLyric = localboo.Mcq;
      localdtj.RfH = localboo.ZWS;
      localdtj.oOZ = localboo.oOZ;
      localdtj.oPc = localboo.ZWS;
      paramArrayOfByte = ac.FLX;
      String str = localboo.mLQ;
      paramArrayOfByte = str;
      if (str == null) {
        paramArrayOfByte = String.valueOf(System.currentTimeMillis());
      }
      s.s(paramArrayOfByte, "finderMVSongInfo.songId?…ntTimeMillis().toString()");
      ac.a(localboo, paramArrayOfByte, localdtj);
      str = localdtj.songName;
      paramArrayOfByte = str;
      if (str == null) {
        paramArrayOfByte = "";
      }
      localIntent.putExtra("key_mv_song_name", paramArrayOfByte);
      str = localdtj.songLyric;
      paramArrayOfByte = str;
      if (str == null) {
        paramArrayOfByte = "";
      }
      localIntent.putExtra("key_mv_song_lyric", paramArrayOfByte);
      str = localdtj.singerName;
      paramArrayOfByte = str;
      if (str == null) {
        paramArrayOfByte = "";
      }
      localIntent.putExtra("key_mv_singer_name", paramArrayOfByte);
      str = localdtj.albumName;
      paramArrayOfByte = str;
      if (str == null) {
        paramArrayOfByte = "";
      }
      localIntent.putExtra("key_mv_album_name", paramArrayOfByte);
      str = localdtj.musicGenre;
      paramArrayOfByte = str;
      if (str == null) {
        paramArrayOfByte = "";
      }
      localIntent.putExtra("key_mv_music_genre", paramArrayOfByte);
      localIntent.putExtra("key_mv_issue_date", String.valueOf(localdtj.issueDate));
      str = localdtj.RfH;
      paramArrayOfByte = str;
      if (str == null) {
        paramArrayOfByte = "";
      }
      localIntent.putExtra("key_mv_album_cover_url", paramArrayOfByte);
      str = localdtj.identification;
      paramArrayOfByte = str;
      if (str == null) {
        paramArrayOfByte = "";
      }
      localIntent.putExtra("key_mv_identification", paramArrayOfByte);
      str = localdtj.extraInfo;
      paramArrayOfByte = str;
      if (str == null) {
        paramArrayOfByte = "";
      }
      localIntent.putExtra("key_mv_extra_info", paramArrayOfByte);
      localIntent.putExtra("key_mv_music_duration", localdtj.LNC);
      localIntent.putExtra("key_mv_music_operation_url", localdtj.musicOperationUrl);
      localIntent.putExtra("key_mv_song_mid", localdtj.oOZ);
      localIntent.putExtra("key_mv_entity_id", paramString);
      paramArrayOfByte = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.ad(paramContext, localIntent);
      AppMethodBeat.o(341481);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(341481);
    }
  }
  
  public static String bV(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(341460);
    s.u(paramArrayOfByte, "bytes");
    try
    {
      boo localboo = new boo();
      localboo.parseFrom(paramArrayOfByte);
      paramArrayOfByte = localboo.ZWS;
      AppMethodBeat.o(341460);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.uniComments.util.a
 * JD-Core Version:    0.7.0.1
 */