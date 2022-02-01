package com.tencent.mobileqq.activity.widget.qqmusic.business.player;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.widget.qqmusic.QQMusicHelper;
import com.tencent.mobileqq.activity.widget.qqmusic.business.session.SessionManager;
import com.tencent.mobileqq.activity.widget.qqmusic.data.Session;
import com.tencent.mobileqq.activity.widget.qqmusic.data.SongInfo;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog;
import com.tencent.qqmusicplayerprocess.netspeed.VkeyManager;

public class Util4AudioStream
{
  public static final String a = "Util4AudioStream";
  
  public static String a(SongInfo paramSongInfo, String paramString, int paramInt)
  {
    String str1;
    if (paramSongInfo == null) {
      str1 = "";
    }
    String str2;
    String str5;
    String str3;
    String str4;
    do
    {
      do
      {
        do
        {
          return str1;
          paramString = AudioConfig.a(paramString);
          if (TextUtils.isEmpty(paramString)) {
            return "";
          }
          str2 = null;
          str5 = SessionManager.a().a().d();
          MLog.a("Util4AudioStream", "getOpenudid2 done " + str5);
          str3 = VkeyManager.getInstance().getVKey();
          str4 = QQMusicHelper.a() + "";
          MLog.a("Util4AudioStream", "getVKey done " + str3);
          if (TextUtils.isEmpty(null)) {
            str2 = "https://ws.stream.qqmusic.qq.com/";
          }
          str1 = paramString;
        } while (TextUtils.isEmpty(str2));
        str1 = paramString;
      } while (TextUtils.isEmpty(str3));
      str1 = paramString;
    } while (TextUtils.isEmpty(str5));
    if (paramSongInfo.a())
    {
      paramSongInfo = a(paramString, str2, str3, str5, paramSongInfo.a(1, SongInfo.a(paramInt)));
      MLog.a("Util4AudioStream", "spliceQQMusicStreamUrl done " + paramSongInfo);
      paramString = paramSongInfo;
      if (str4 != null) {
        paramString = paramSongInfo + "&uin=" + str4;
      }
      paramSongInfo = UtilForFromTag.b(paramString);
      paramString = new StringBuilder().append("getFinalPlayUrl -> hasHQVkey:");
      if (paramInt < 700) {
        break label347;
      }
    }
    label347:
    for (boolean bool = true;; bool = false)
    {
      for (;;)
      {
        MLog.a("Util4AudioStream", bool + "|| vkey :" + str3 + "\r\nurl:" + paramSongInfo);
        return paramSongInfo;
        if (paramSongInfo.b()) {
          try
          {
            if (paramString.startsWith("https://share.weiyun.qq.com/share_dl.fcg")) {
              paramSongInfo = a(paramString, str3, str5);
            }
          }
          catch (Exception paramSongInfo)
          {
            paramSongInfo.printStackTrace();
          }
        }
      }
      paramSongInfo = paramString;
      break;
    }
  }
  
  private static String a(String paramString1, String paramString2, String paramString3)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramString1);
    localStringBuffer.append("?vkey=");
    localStringBuffer.append(paramString2);
    localStringBuffer.append("&guid=");
    localStringBuffer.append(paramString3);
    return localStringBuffer.toString();
  }
  
  private static String a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    MLog.a("Util4AudioStream", "spliceQQMusicStreamUrl needpay=" + paramInt);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramString2);
    if ((paramString1.contains("?")) && (paramString1.lastIndexOf("/") + 1 < paramString1.indexOf("?"))) {
      paramString1 = paramString1.substring(paramString1.lastIndexOf("/") + 1, paramString1.indexOf("?"));
    }
    for (;;)
    {
      localStringBuffer.append(paramString1);
      localStringBuffer.append("?vkey=");
      localStringBuffer.append(paramString3);
      localStringBuffer.append("&guid=");
      localStringBuffer.append(paramString4);
      try
      {
        paramString1 = VkeyManager.getInstance().getContKey(paramString1, paramInt);
        localStringBuffer.append("&continfo=");
        if (paramString1 != null)
        {
          localStringBuffer.append(paramString1);
          return localStringBuffer.toString();
          paramString1 = paramString1.substring(paramString1.lastIndexOf("/") + 1);
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          MLog.a("Util4AudioStream", paramString1);
          paramString1 = null;
          continue;
          localStringBuffer.append("");
        }
      }
    }
  }
  
  /* Error */
  @android.annotation.SuppressLint({"NewApi"})
  public static boolean a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: new 182	java/io/RandomAccessFile
    //   9: dup
    //   10: aload_0
    //   11: ldc 184
    //   13: invokespecial 186	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: astore_1
    //   17: new 188	android/media/MediaMetadataRetriever
    //   20: dup
    //   21: invokespecial 189	android/media/MediaMetadataRetriever:<init>	()V
    //   24: astore 5
    //   26: aload 5
    //   28: astore_3
    //   29: aload_1
    //   30: astore_2
    //   31: aload 5
    //   33: aload_1
    //   34: invokevirtual 193	java/io/RandomAccessFile:getFD	()Ljava/io/FileDescriptor;
    //   37: invokevirtual 197	android/media/MediaMetadataRetriever:setDataSource	(Ljava/io/FileDescriptor;)V
    //   40: aload 5
    //   42: astore_3
    //   43: aload_1
    //   44: astore_2
    //   45: aload 5
    //   47: bipush 12
    //   49: invokevirtual 200	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   52: astore 7
    //   54: aload 4
    //   56: astore_0
    //   57: aload 7
    //   59: ifnull +21 -> 80
    //   62: aload 5
    //   64: astore_3
    //   65: aload_1
    //   66: astore_2
    //   67: ldc 2
    //   69: invokevirtual 205	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   72: aload 7
    //   74: invokestatic 60	com/tencent/mobileqq/activity/widget/qqmusic/utils/MLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: aload 7
    //   79: astore_0
    //   80: aload 5
    //   82: ifnull +8 -> 90
    //   85: aload 5
    //   87: invokevirtual 208	android/media/MediaMetadataRetriever:release	()V
    //   90: aload_0
    //   91: astore_2
    //   92: aload_1
    //   93: ifnull +9 -> 102
    //   96: aload_1
    //   97: invokevirtual 211	java/io/RandomAccessFile:close	()V
    //   100: aload_0
    //   101: astore_2
    //   102: aload_2
    //   103: ifnull +97 -> 200
    //   106: iconst_1
    //   107: ireturn
    //   108: astore_1
    //   109: aload_1
    //   110: invokevirtual 212	java/io/IOException:printStackTrace	()V
    //   113: aload_0
    //   114: astore_2
    //   115: goto -13 -> 102
    //   118: astore 4
    //   120: aconst_null
    //   121: astore_0
    //   122: aconst_null
    //   123: astore_1
    //   124: aload_0
    //   125: astore_3
    //   126: aload_1
    //   127: astore_2
    //   128: aload 4
    //   130: invokevirtual 129	java/lang/Exception:printStackTrace	()V
    //   133: aload_0
    //   134: ifnull +7 -> 141
    //   137: aload_0
    //   138: invokevirtual 208	android/media/MediaMetadataRetriever:release	()V
    //   141: aload 6
    //   143: astore_2
    //   144: aload_1
    //   145: ifnull -43 -> 102
    //   148: aload_1
    //   149: invokevirtual 211	java/io/RandomAccessFile:close	()V
    //   152: aload 6
    //   154: astore_2
    //   155: goto -53 -> 102
    //   158: astore_0
    //   159: aload_0
    //   160: invokevirtual 212	java/io/IOException:printStackTrace	()V
    //   163: aload 6
    //   165: astore_2
    //   166: goto -64 -> 102
    //   169: astore_0
    //   170: aconst_null
    //   171: astore_3
    //   172: aconst_null
    //   173: astore_1
    //   174: aload_3
    //   175: ifnull +7 -> 182
    //   178: aload_3
    //   179: invokevirtual 208	android/media/MediaMetadataRetriever:release	()V
    //   182: aload_1
    //   183: ifnull +7 -> 190
    //   186: aload_1
    //   187: invokevirtual 211	java/io/RandomAccessFile:close	()V
    //   190: aload_0
    //   191: athrow
    //   192: astore_1
    //   193: aload_1
    //   194: invokevirtual 212	java/io/IOException:printStackTrace	()V
    //   197: goto -7 -> 190
    //   200: iconst_0
    //   201: ireturn
    //   202: astore_0
    //   203: aconst_null
    //   204: astore_3
    //   205: goto -31 -> 174
    //   208: astore_0
    //   209: aload_2
    //   210: astore_1
    //   211: goto -37 -> 174
    //   214: astore 4
    //   216: aconst_null
    //   217: astore_0
    //   218: goto -94 -> 124
    //   221: astore 4
    //   223: aload 5
    //   225: astore_0
    //   226: goto -102 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	paramString	String
    //   16	81	1	localRandomAccessFile	java.io.RandomAccessFile
    //   108	2	1	localIOException1	java.io.IOException
    //   123	64	1	localObject1	Object
    //   192	2	1	localIOException2	java.io.IOException
    //   210	1	1	localObject2	Object
    //   30	180	2	localObject3	Object
    //   28	177	3	localObject4	Object
    //   4	51	4	localObject5	Object
    //   118	11	4	localException1	Exception
    //   214	1	4	localException2	Exception
    //   221	1	4	localException3	Exception
    //   24	200	5	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   1	163	6	localObject6	Object
    //   52	26	7	str	String
    // Exception table:
    //   from	to	target	type
    //   96	100	108	java/io/IOException
    //   6	17	118	java/lang/Exception
    //   148	152	158	java/io/IOException
    //   6	17	169	finally
    //   186	190	192	java/io/IOException
    //   17	26	202	finally
    //   31	40	208	finally
    //   45	54	208	finally
    //   67	77	208	finally
    //   128	133	208	finally
    //   17	26	214	java/lang/Exception
    //   31	40	221	java/lang/Exception
    //   45	54	221	java/lang/Exception
    //   67	77	221	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.business.player.Util4AudioStream
 * JD-Core Version:    0.7.0.1
 */