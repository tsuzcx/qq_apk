package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadConstants;
import fvk;
import fvl;
import fvm;
import org.json.JSONObject;

public class PAGameItemBuilder
  extends AbstractChatItemBuilder
{
  private static final long jdField_b_of_type_Long = 1000L;
  private long jdField_a_of_type_Long = 0L;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new fvk(this);
  private final int[] jdField_a_of_type_ArrayOfInt = { 2130837591, 2130837592, 2130837593 };
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  
  public PAGameItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.b = new fvl(this);
  }
  
  private void a(Bundle paramBundle)
  {
    try
    {
      paramBundle.putInt(DownloadConstants.j, 2);
      paramBundle.putString(DownloadConstants.h, "ANDROIDQQ.GAME.RECENT");
      paramBundle.putInt(DownloadConstants.m, 0);
      paramBundle.putBoolean(DownloadConstants.f, true);
      paramBundle.putBoolean(DownloadConstants.g, true);
      DownloadApi.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, paramBundle, 2, null, 1);
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  /* Error */
  private void a(PAMessage.Item paramItem)
  {
    // Byte code:
    //   0: new 98	org/json/JSONObject
    //   3: dup
    //   4: aload_1
    //   5: getfield 103	com/tencent/mobileqq/data/PAMessage$Item:a_rankListUrl	Ljava/lang/String;
    //   8: invokespecial 106	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11: astore 4
    //   13: aload 4
    //   15: invokevirtual 110	org/json/JSONObject:length	()I
    //   18: iconst_2
    //   19: if_icmpeq +4 -> 23
    //   22: return
    //   23: aload 4
    //   25: ldc 112
    //   27: invokevirtual 116	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   30: astore_3
    //   31: aload_1
    //   32: aload 4
    //   34: ldc 117
    //   36: invokevirtual 116	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   39: invokestatic 123	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   42: i2l
    //   43: putfield 126	com/tencent/mobileqq/data/PAMessage$Item:appId	J
    //   46: new 48	android/os/Bundle
    //   49: dup
    //   50: invokespecial 128	android/os/Bundle:<init>	()V
    //   53: astore 4
    //   55: new 98	org/json/JSONObject
    //   58: dup
    //   59: aload_1
    //   60: getfield 131	com/tencent/mobileqq/data/PAMessage$Item:rankListDownload	Ljava/lang/String;
    //   63: invokespecial 106	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   66: astore 5
    //   68: aload 5
    //   70: invokevirtual 110	org/json/JSONObject:length	()I
    //   73: bipush 6
    //   75: if_icmpne +181 -> 256
    //   78: aload 4
    //   80: getstatic 133	com/tencent/open/downloadnew/DownloadConstants:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   83: aload 5
    //   85: ldc 117
    //   87: invokevirtual 116	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   90: invokevirtual 61	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: aload 4
    //   95: getstatic 136	com/tencent/open/downloadnew/DownloadConstants:k	Ljava/lang/String;
    //   98: aload 5
    //   100: ldc 138
    //   102: invokevirtual 116	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   105: invokevirtual 61	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload 4
    //   110: getstatic 141	com/tencent/open/downloadnew/DownloadConstants:i	Ljava/lang/String;
    //   113: aload 5
    //   115: ldc 112
    //   117: invokevirtual 116	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   120: invokevirtual 61	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: aload 4
    //   125: getstatic 144	com/tencent/open/downloadnew/DownloadConstants:e	Ljava/lang/String;
    //   128: aload 5
    //   130: ldc 146
    //   132: invokevirtual 116	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   135: invokevirtual 61	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: aload 4
    //   140: getstatic 149	com/tencent/open/downloadnew/DownloadConstants:d	Ljava/lang/String;
    //   143: aload 5
    //   145: ldc 151
    //   147: invokevirtual 154	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   150: invokevirtual 52	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   153: aload 4
    //   155: getstatic 156	com/tencent/open/downloadnew/DownloadConstants:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   158: aload 5
    //   160: ldc 157
    //   162: invokevirtual 116	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   165: invokevirtual 61	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: aload_3
    //   169: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   172: ifne +84 -> 256
    //   175: aload_1
    //   176: getfield 126	com/tencent/mobileqq/data/PAMessage$Item:appId	J
    //   179: lconst_0
    //   180: lcmp
    //   181: ifne +64 -> 245
    //   184: iconst_0
    //   185: istore_2
    //   186: iload_2
    //   187: ifeq +69 -> 256
    //   190: aload_0
    //   191: getfield 77	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   194: aload 4
    //   196: getstatic 144	com/tencent/open/downloadnew/DownloadConstants:e	Ljava/lang/String;
    //   199: invokevirtual 166	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   202: invokestatic 171	com/tencent/mobileqq/utils/PackageUtil:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   205: ifeq +45 -> 250
    //   208: aload_0
    //   209: getfield 174	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   212: aload_0
    //   213: getfield 77	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   216: aconst_null
    //   217: aload_1
    //   218: getfield 126	com/tencent/mobileqq/data/PAMessage$Item:appId	J
    //   221: aload_3
    //   222: invokestatic 179	com/tencent/mobileqq/activity/aio/item/PASingleItemBuilder:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;JLjava/lang/String;)Z
    //   225: pop
    //   226: return
    //   227: astore_1
    //   228: aload_1
    //   229: invokevirtual 180	java/lang/NumberFormatException:printStackTrace	()V
    //   232: return
    //   233: astore_1
    //   234: aload_1
    //   235: invokevirtual 181	org/json/JSONException:printStackTrace	()V
    //   238: return
    //   239: astore_1
    //   240: aload_1
    //   241: invokevirtual 181	org/json/JSONException:printStackTrace	()V
    //   244: return
    //   245: iconst_1
    //   246: istore_2
    //   247: goto -61 -> 186
    //   250: aload_0
    //   251: aload 4
    //   253: invokespecial 183	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:a	(Landroid/os/Bundle;)V
    //   256: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	this	PAGameItemBuilder
    //   0	257	1	paramItem	PAMessage.Item
    //   185	62	2	i	int
    //   30	192	3	str	String
    //   11	241	4	localObject	java.lang.Object
    //   66	93	5	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   31	46	227	java/lang/NumberFormatException
    //   0	22	233	org/json/JSONException
    //   23	31	233	org/json/JSONException
    //   31	46	233	org/json/JSONException
    //   228	232	233	org/json/JSONException
    //   55	168	239	org/json/JSONException
  }
  
  private boolean a(PAMessage.Item paramItem)
  {
    try
    {
      paramItem = new JSONObject(paramItem.rankListDownload).optString("p");
      boolean bool = PackageUtil.a(this.jdField_a_of_type_AndroidContentContext, paramItem);
      if (bool) {
        return true;
      }
    }
    catch (Exception paramItem)
    {
      paramItem.printStackTrace();
    }
    return false;
  }
  
  /* Error */
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, android.widget.LinearLayout paramLinearLayout, com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    // Byte code:
    //   0: new 187	android/widget/LinearLayout
    //   3: dup
    //   4: aload_0
    //   5: getfield 77	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   8: invokespecial 190	android/widget/LinearLayout:<init>	(Landroid/content/Context;)V
    //   11: astore_2
    //   12: aload_2
    //   13: checkcast 187	android/widget/LinearLayout
    //   16: iconst_1
    //   17: invokevirtual 194	android/widget/LinearLayout:setOrientation	(I)V
    //   20: aload_1
    //   21: checkcast 196	com/tencent/mobileqq/data/MessageForPubAccount
    //   24: astore_3
    //   25: aload_3
    //   26: getfield 200	com/tencent/mobileqq/data/MessageForPubAccount:mPAMessage	Lcom/tencent/mobileqq/data/PAMessage;
    //   29: astore 4
    //   31: fconst_1
    //   32: getstatic 205	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:d	F
    //   35: fmul
    //   36: f2i
    //   37: istore 8
    //   39: aload 4
    //   41: getfield 211	com/tencent/mobileqq/data/PAMessage:items	Ljava/util/ArrayList;
    //   44: astore 9
    //   46: aload_2
    //   47: checkcast 213	android/view/ViewGroup
    //   50: astore 10
    //   52: iconst_0
    //   53: istore 6
    //   55: iload 6
    //   57: aload 9
    //   59: invokevirtual 218	java/util/ArrayList:size	()I
    //   62: if_icmpge +889 -> 951
    //   65: new 220	fvm
    //   68: dup
    //   69: aload_0
    //   70: invokespecial 221	fvm:<init>	(Lcom/tencent/mobileqq/activity/aio/item/PAGameItemBuilder;)V
    //   73: astore 11
    //   75: aload 9
    //   77: iload 6
    //   79: invokevirtual 225	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   82: checkcast 100	com/tencent/mobileqq/data/PAMessage$Item
    //   85: astore 12
    //   87: aload 11
    //   89: iconst_5
    //   90: putfield 228	fvm:jdField_a_of_type_Int	I
    //   93: aload 11
    //   95: aload 12
    //   97: getfield 231	com/tencent/mobileqq/data/PAMessage$Item:url	Ljava/lang/String;
    //   100: putfield 234	fvm:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   103: aload 11
    //   105: aload 4
    //   107: getfield 237	com/tencent/mobileqq/data/PAMessage:type	I
    //   110: putfield 239	fvm:jdField_b_of_type_Int	I
    //   113: aload 11
    //   115: aload 12
    //   117: getfield 242	com/tencent/mobileqq/data/PAMessage$Item:actionUrl	Ljava/lang/String;
    //   120: putfield 243	fvm:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   123: aload 11
    //   125: aload 12
    //   127: getfield 246	com/tencent/mobileqq/data/PAMessage$Item:nativeJumpString	Ljava/lang/String;
    //   130: putfield 247	fvm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   133: aload 11
    //   135: aload_3
    //   136: getfield 250	com/tencent/mobileqq/data/MessageForPubAccount:uniseq	J
    //   139: putfield 251	fvm:jdField_a_of_type_Long	J
    //   142: aload 11
    //   144: iload 6
    //   146: putfield 253	fvm:jdField_c_of_type_Int	I
    //   149: iload 6
    //   151: ifne +12 -> 163
    //   154: iload 6
    //   156: iconst_1
    //   157: iadd
    //   158: istore 6
    //   160: goto -105 -> 55
    //   163: iload 6
    //   165: iconst_1
    //   166: if_icmpne +426 -> 592
    //   169: aload_0
    //   170: getfield 77	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   173: invokestatic 259	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   176: ldc_w 260
    //   179: aconst_null
    //   180: invokevirtual 264	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   183: astore_1
    //   184: aload_1
    //   185: ldc_w 265
    //   188: invokevirtual 271	android/view/View:findViewById	(I)Landroid/view/View;
    //   191: checkcast 273	android/widget/ImageView
    //   194: astore 14
    //   196: aload_1
    //   197: ldc_w 274
    //   200: invokevirtual 271	android/view/View:findViewById	(I)Landroid/view/View;
    //   203: checkcast 276	android/widget/TextView
    //   206: astore 13
    //   208: aload 9
    //   210: iconst_0
    //   211: invokevirtual 225	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   214: checkcast 100	com/tencent/mobileqq/data/PAMessage$Item
    //   217: getfield 279	com/tencent/mobileqq/data/PAMessage$Item:cover	Ljava/lang/String;
    //   220: astore 15
    //   222: aload 14
    //   224: aload 15
    //   226: invokestatic 285	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;)Lcom/tencent/image/URLDrawable;
    //   229: invokevirtual 289	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   232: aload 9
    //   234: iconst_0
    //   235: invokevirtual 225	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   238: checkcast 100	com/tencent/mobileqq/data/PAMessage$Item
    //   241: getfield 292	com/tencent/mobileqq/data/PAMessage$Item:title	Ljava/lang/String;
    //   244: astore 14
    //   246: aload 14
    //   248: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   251: ifne +331 -> 582
    //   254: aload 13
    //   256: aload 14
    //   258: invokevirtual 296	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   261: aload_1
    //   262: ldc_w 297
    //   265: invokevirtual 271	android/view/View:findViewById	(I)Landroid/view/View;
    //   268: checkcast 273	android/widget/ImageView
    //   271: astore 14
    //   273: aload_1
    //   274: ldc_w 298
    //   277: invokevirtual 271	android/view/View:findViewById	(I)Landroid/view/View;
    //   280: checkcast 273	android/widget/ImageView
    //   283: astore 15
    //   285: aload_1
    //   286: ldc_w 299
    //   289: invokevirtual 271	android/view/View:findViewById	(I)Landroid/view/View;
    //   292: checkcast 276	android/widget/TextView
    //   295: astore 16
    //   297: aload_1
    //   298: ldc_w 300
    //   301: invokevirtual 271	android/view/View:findViewById	(I)Landroid/view/View;
    //   304: checkcast 276	android/widget/TextView
    //   307: astore 17
    //   309: aload_1
    //   310: ldc_w 301
    //   313: invokevirtual 271	android/view/View:findViewById	(I)Landroid/view/View;
    //   316: checkcast 276	android/widget/TextView
    //   319: astore 18
    //   321: aload_1
    //   322: ldc_w 302
    //   325: invokevirtual 271	android/view/View:findViewById	(I)Landroid/view/View;
    //   328: checkcast 304	android/widget/RelativeLayout
    //   331: astore 13
    //   333: aload_0
    //   334: aload 12
    //   336: invokespecial 306	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:a	(Lcom/tencent/mobileqq/data/PAMessage$Item;)Z
    //   339: ifeq +479 -> 818
    //   342: aload 12
    //   344: ldc_w 308
    //   347: putfield 311	com/tencent/mobileqq/data/PAMessage$Item:rankListName	Ljava/lang/String;
    //   350: aload 18
    //   352: aload 12
    //   354: getfield 311	com/tencent/mobileqq/data/PAMessage$Item:rankListName	Ljava/lang/String;
    //   357: invokevirtual 296	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   360: aload 16
    //   362: aload 12
    //   364: getfield 292	com/tencent/mobileqq/data/PAMessage$Item:title	Ljava/lang/String;
    //   367: invokestatic 315	com/tencent/biz/common/util/Util:e	(Ljava/lang/String;)Ljava/lang/String;
    //   370: invokevirtual 296	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   373: aload 17
    //   375: aload 12
    //   377: getfield 318	com/tencent/mobileqq/data/PAMessage$Item:desc	Ljava/lang/String;
    //   380: invokevirtual 296	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   383: new 320	android/util/DisplayMetrics
    //   386: dup
    //   387: invokespecial 321	android/util/DisplayMetrics:<init>	()V
    //   390: astore 18
    //   392: aload_0
    //   393: getfield 77	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   396: checkcast 323	android/app/Activity
    //   399: invokevirtual 327	android/app/Activity:getWindowManager	()Landroid/view/WindowManager;
    //   402: invokeinterface 333 1 0
    //   407: aload 18
    //   409: invokevirtual 339	android/view/Display:getMetrics	(Landroid/util/DisplayMetrics;)V
    //   412: aload 12
    //   414: getfield 311	com/tencent/mobileqq/data/PAMessage$Item:rankListName	Ljava/lang/String;
    //   417: invokevirtual 342	java/lang/String:length	()I
    //   420: iconst_4
    //   421: if_icmple +419 -> 840
    //   424: iconst_4
    //   425: istore 7
    //   427: aload 18
    //   429: getfield 345	android/util/DisplayMetrics:widthPixels	I
    //   432: iload 7
    //   434: bipush 15
    //   436: imul
    //   437: sipush 151
    //   440: iadd
    //   441: i2f
    //   442: aload_0
    //   443: getfield 77	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   446: invokevirtual 351	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   449: invokestatic 356	com/tencent/mobileqq/activity/aio/AIOUtils:a	(FLandroid/content/res/Resources;)I
    //   452: isub
    //   453: istore 7
    //   455: aload 16
    //   457: iload 7
    //   459: invokevirtual 359	android/widget/TextView:setMaxWidth	(I)V
    //   462: iload 6
    //   464: iconst_1
    //   465: if_icmpeq +10 -> 475
    //   468: aload 17
    //   470: iload 7
    //   472: invokevirtual 359	android/widget/TextView:setMaxWidth	(I)V
    //   475: aload 15
    //   477: aload 12
    //   479: getfield 279	com/tencent/mobileqq/data/PAMessage$Item:cover	Ljava/lang/String;
    //   482: invokestatic 285	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;)Lcom/tencent/image/URLDrawable;
    //   485: invokevirtual 289	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   488: iload 6
    //   490: iconst_3
    //   491: if_icmpgt +375 -> 866
    //   494: aload 14
    //   496: aload_0
    //   497: getfield 77	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   500: invokevirtual 351	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   503: aload_0
    //   504: getfield 22	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_ArrayOfInt	[I
    //   507: iload 6
    //   509: iconst_1
    //   510: isub
    //   511: iaload
    //   512: invokevirtual 364	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   515: invokevirtual 289	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   518: aload 10
    //   520: aload_1
    //   521: invokevirtual 368	android/view/ViewGroup:addView	(Landroid/view/View;)V
    //   524: aload 13
    //   526: aload 11
    //   528: invokevirtual 372	android/widget/RelativeLayout:setTag	(Ljava/lang/Object;)V
    //   531: aload 13
    //   533: aload_0
    //   534: getfield 34	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:b	Landroid/view/View$OnClickListener;
    //   537: invokevirtual 376	android/widget/RelativeLayout:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   540: aload_1
    //   541: aload 11
    //   543: invokevirtual 377	android/view/View:setTag	(Ljava/lang/Object;)V
    //   546: aload_1
    //   547: aload_0
    //   548: getfield 29	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_AndroidViewView$OnClickListener	Landroid/view/View$OnClickListener;
    //   551: invokevirtual 378	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   554: aload_1
    //   555: aload 5
    //   557: invokevirtual 382	android/view/View:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   560: aload_1
    //   561: aload 5
    //   563: invokevirtual 386	android/view/View:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   566: goto -412 -> 154
    //   569: astore 15
    //   571: aload 14
    //   573: ldc_w 387
    //   576: invokevirtual 390	android/widget/ImageView:setImageResource	(I)V
    //   579: goto -347 -> 232
    //   582: aload 13
    //   584: bipush 8
    //   586: invokevirtual 393	android/widget/TextView:setVisibility	(I)V
    //   589: goto -328 -> 261
    //   592: iload 6
    //   594: aload 9
    //   596: invokevirtual 218	java/util/ArrayList:size	()I
    //   599: iconst_1
    //   600: isub
    //   601: if_icmpne +120 -> 721
    //   604: aload_0
    //   605: getfield 77	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   608: invokestatic 259	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   611: ldc_w 394
    //   614: aconst_null
    //   615: invokevirtual 264	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   618: astore_1
    //   619: aload_1
    //   620: new 396	android/widget/RelativeLayout$LayoutParams
    //   623: dup
    //   624: iconst_m1
    //   625: ldc_w 397
    //   628: aload_0
    //   629: getfield 77	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   632: invokevirtual 351	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   635: invokestatic 356	com/tencent/mobileqq/activity/aio/AIOUtils:a	(FLandroid/content/res/Resources;)I
    //   638: invokespecial 400	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   641: invokevirtual 404	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   644: aload_1
    //   645: iconst_0
    //   646: iconst_0
    //   647: iconst_0
    //   648: iconst_0
    //   649: invokevirtual 408	android/view/View:setPadding	(IIII)V
    //   652: aload_1
    //   653: aload_0
    //   654: getfield 77	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   657: invokevirtual 351	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   660: ldc_w 409
    //   663: invokevirtual 364	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   666: invokevirtual 412	android/view/View:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   669: aload_1
    //   670: ldc_w 413
    //   673: invokevirtual 271	android/view/View:findViewById	(I)Landroid/view/View;
    //   676: astore 13
    //   678: new 396	android/widget/RelativeLayout$LayoutParams
    //   681: dup
    //   682: iconst_m1
    //   683: iload 8
    //   685: invokespecial 400	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   688: astore 14
    //   690: aload 14
    //   692: ldc_w 414
    //   695: aload_0
    //   696: getfield 77	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   699: invokevirtual 351	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   702: invokestatic 356	com/tencent/mobileqq/activity/aio/AIOUtils:a	(FLandroid/content/res/Resources;)I
    //   705: iconst_0
    //   706: iconst_0
    //   707: iconst_0
    //   708: invokevirtual 417	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   711: aload 13
    //   713: aload 14
    //   715: invokevirtual 404	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   718: goto -457 -> 261
    //   721: aload_0
    //   722: getfield 77	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   725: invokestatic 259	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   728: ldc_w 394
    //   731: aconst_null
    //   732: invokevirtual 264	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   735: astore_1
    //   736: aload_1
    //   737: ldc_w 413
    //   740: invokevirtual 271	android/view/View:findViewById	(I)Landroid/view/View;
    //   743: astore 13
    //   745: new 396	android/widget/RelativeLayout$LayoutParams
    //   748: dup
    //   749: iconst_m1
    //   750: iload 8
    //   752: invokespecial 400	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   755: astore 14
    //   757: iload 6
    //   759: iconst_2
    //   760: if_icmpne +34 -> 794
    //   763: aload 14
    //   765: ldc_w 418
    //   768: aload_0
    //   769: getfield 77	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   772: invokevirtual 351	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   775: invokestatic 356	com/tencent/mobileqq/activity/aio/AIOUtils:a	(FLandroid/content/res/Resources;)I
    //   778: iconst_0
    //   779: iconst_0
    //   780: iconst_0
    //   781: invokevirtual 417	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   784: aload 13
    //   786: aload 14
    //   788: invokevirtual 404	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   791: goto -530 -> 261
    //   794: aload 14
    //   796: ldc_w 414
    //   799: aload_0
    //   800: getfield 77	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   803: invokevirtual 351	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   806: invokestatic 356	com/tencent/mobileqq/activity/aio/AIOUtils:a	(FLandroid/content/res/Resources;)I
    //   809: iconst_0
    //   810: iconst_0
    //   811: iconst_0
    //   812: invokevirtual 417	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   815: goto -31 -> 784
    //   818: aload 12
    //   820: getfield 311	com/tencent/mobileqq/data/PAMessage$Item:rankListName	Ljava/lang/String;
    //   823: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   826: ifeq -476 -> 350
    //   829: aload 12
    //   831: ldc_w 420
    //   834: putfield 311	com/tencent/mobileqq/data/PAMessage$Item:rankListName	Ljava/lang/String;
    //   837: goto -487 -> 350
    //   840: aload 12
    //   842: getfield 311	com/tencent/mobileqq/data/PAMessage$Item:rankListName	Ljava/lang/String;
    //   845: invokevirtual 342	java/lang/String:length	()I
    //   848: istore 7
    //   850: goto -423 -> 427
    //   853: astore 12
    //   855: aload 15
    //   857: ldc_w 387
    //   860: invokevirtual 390	android/widget/ImageView:setImageResource	(I)V
    //   863: goto -375 -> 488
    //   866: aload 14
    //   868: invokevirtual 424	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   871: astore 12
    //   873: aload 14
    //   875: bipush 8
    //   877: invokevirtual 425	android/widget/ImageView:setVisibility	(I)V
    //   880: new 276	android/widget/TextView
    //   883: dup
    //   884: aload_0
    //   885: getfield 77	com/tencent/mobileqq/activity/aio/item/PAGameItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   888: invokespecial 426	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   891: astore 14
    //   893: aload 14
    //   895: bipush 17
    //   897: invokevirtual 429	android/widget/TextView:setGravity	(I)V
    //   900: aload 14
    //   902: iload 6
    //   904: invokestatic 433	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   907: invokevirtual 296	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   910: aload 14
    //   912: getstatic 439	android/graphics/Typeface:DEFAULT_BOLD	Landroid/graphics/Typeface;
    //   915: invokevirtual 443	android/widget/TextView:setTypeface	(Landroid/graphics/Typeface;)V
    //   918: aload 14
    //   920: iconst_2
    //   921: ldc_w 444
    //   924: invokevirtual 448	android/widget/TextView:setTextSize	(IF)V
    //   927: aload_1
    //   928: checkcast 304	android/widget/RelativeLayout
    //   931: aload 14
    //   933: aload 12
    //   935: invokevirtual 451	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   938: goto -420 -> 518
    //   941: astore 12
    //   943: aload 12
    //   945: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   948: goto -430 -> 518
    //   951: aload_2
    //   952: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	953	0	this	PAGameItemBuilder
    //   0	953	1	paramMessageRecord	MessageRecord
    //   0	953	2	paramViewHolder	AbstractChatItemBuilder.ViewHolder
    //   0	953	3	paramView	View
    //   0	953	4	paramLinearLayout	android.widget.LinearLayout
    //   0	953	5	paramOnLongClickAndTouchListener	com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener
    //   53	850	6	i	int
    //   425	424	7	j	int
    //   37	714	8	k	int
    //   44	551	9	localArrayList	java.util.ArrayList
    //   50	469	10	localViewGroup	android.view.ViewGroup
    //   73	469	11	localfvm	fvm
    //   85	756	12	localItem	PAMessage.Item
    //   853	1	12	localException1	Exception
    //   871	63	12	localLayoutParams	android.view.ViewGroup.LayoutParams
    //   941	3	12	localException2	Exception
    //   206	579	13	localObject1	java.lang.Object
    //   194	738	14	localObject2	java.lang.Object
    //   220	256	15	localObject3	java.lang.Object
    //   569	287	15	localException3	Exception
    //   295	161	16	localTextView1	android.widget.TextView
    //   307	162	17	localTextView2	android.widget.TextView
    //   319	109	18	localObject4	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   222	232	569	java/lang/Exception
    //   475	488	853	java/lang/Exception
    //   494	518	941	java/lang/Exception
    //   866	938	941	java/lang/Exception
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new fvm(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      return;
    }
    paramContext = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    if ((paramContext != null) && (paramContext.uniseq == paramChatMessage.uniseq)) {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    long l = paramChatMessage.uniseq;
    if (paramChatMessage.issend == 1) {}
    for (;;)
    {
      PublicAccountUtil.a(paramContext, localContext, str, paramInt, l, bool);
      return;
      bool = false;
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    paramView.a(2131302479, this.jdField_a_of_type_AndroidContentContext.getString(2131366320));
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PAGameItemBuilder
 * JD-Core Version:    0.7.0.1
 */