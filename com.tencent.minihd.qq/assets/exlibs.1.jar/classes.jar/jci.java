import android.content.BroadcastReceiver;
import com.tencent.mobileqq.jsp.EventApiPlugin;

public class jci
  extends BroadcastReceiver
{
  public jci(EventApiPlugin paramEventApiPlugin) {}
  
  /* Error */
  public void onReceive(android.content.Context paramContext, android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_2
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_2
    //   9: ldc 20
    //   11: iconst_1
    //   12: invokevirtual 26	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   15: ifeq -8 -> 7
    //   18: aload_2
    //   19: ldc 28
    //   21: invokevirtual 32	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   24: astore_1
    //   25: aload_1
    //   26: ifnull +17 -> 43
    //   29: aload_1
    //   30: aload_0
    //   31: getfield 10	jci:a	Lcom/tencent/mobileqq/jsp/EventApiPlugin;
    //   34: getfield 38	com/tencent/mobileqq/jsp/EventApiPlugin:l	Ljava/lang/String;
    //   37: invokevirtual 44	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   40: ifne -33 -> 7
    //   43: aload_2
    //   44: ldc 46
    //   46: invokevirtual 32	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   49: astore 6
    //   51: aload 6
    //   53: invokestatic 52	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   56: ifne -49 -> 7
    //   59: aload_2
    //   60: ldc 54
    //   62: invokevirtual 32	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   65: astore_1
    //   66: aload_1
    //   67: ifnull +145 -> 212
    //   70: new 56	org/json/JSONObject
    //   73: dup
    //   74: aload_1
    //   75: invokespecial 59	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   78: astore_1
    //   79: aload_2
    //   80: ldc 61
    //   82: invokevirtual 65	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   85: astore 7
    //   87: aload 7
    //   89: ifnull -82 -> 7
    //   92: aload_2
    //   93: ldc 67
    //   95: invokevirtual 32	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   98: astore 8
    //   100: aload 5
    //   102: astore_2
    //   103: aload 8
    //   105: ifnull +13 -> 118
    //   108: new 56	org/json/JSONObject
    //   111: dup
    //   112: aload 8
    //   114: invokespecial 59	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   117: astore_2
    //   118: aload_0
    //   119: getfield 10	jci:a	Lcom/tencent/mobileqq/jsp/EventApiPlugin;
    //   122: getfield 71	com/tencent/mobileqq/jsp/EventApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   125: invokevirtual 76	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   128: astore 5
    //   130: aload 5
    //   132: ifnull -125 -> 7
    //   135: aload 5
    //   137: invokevirtual 82	com/tencent/smtt/sdk/WebView:getUrl	()Ljava/lang/String;
    //   140: astore 5
    //   142: aload 5
    //   144: ifnull -137 -> 7
    //   147: aload 5
    //   149: invokestatic 88	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   152: invokevirtual 91	android/net/Uri:getHost	()Ljava/lang/String;
    //   155: astore 5
    //   157: aload 7
    //   159: invokevirtual 97	java/util/ArrayList:size	()I
    //   162: istore 4
    //   164: iconst_0
    //   165: istore_3
    //   166: iload_3
    //   167: iload 4
    //   169: if_icmpge -162 -> 7
    //   172: aload 7
    //   174: iload_3
    //   175: invokevirtual 101	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   178: checkcast 40	java/lang/String
    //   181: aload 5
    //   183: invokestatic 107	com/tencent/biz/AuthorizeConfig:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   186: ifeq +15 -> 201
    //   189: aload_0
    //   190: getfield 10	jci:a	Lcom/tencent/mobileqq/jsp/EventApiPlugin;
    //   193: aload 6
    //   195: aload_1
    //   196: aload_2
    //   197: invokevirtual 111	com/tencent/mobileqq/jsp/EventApiPlugin:dispatchJsEvent	(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;)V
    //   200: return
    //   201: iload_3
    //   202: iconst_1
    //   203: iadd
    //   204: istore_3
    //   205: goto -39 -> 166
    //   208: astore_1
    //   209: return
    //   210: astore_1
    //   211: return
    //   212: aconst_null
    //   213: astore_1
    //   214: goto -135 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	jci
    //   0	217	1	paramContext	android.content.Context
    //   0	217	2	paramIntent	android.content.Intent
    //   165	40	3	i	int
    //   162	8	4	j	int
    //   1	181	5	localObject	java.lang.Object
    //   49	145	6	str1	java.lang.String
    //   85	88	7	localArrayList	java.util.ArrayList
    //   98	15	8	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   108	118	208	org/json/JSONException
    //   70	79	210	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jci
 * JD-Core Version:    0.7.0.1
 */