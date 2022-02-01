package com.tencent.mobileqq.dating;

import EncounterSvc.EntranceContent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.CarrierADView;
import hzj;
import java.util.List;
import tencent.im.nearby.entrance.nearby_entrance_common.NearbyEntranceContent;

public class CarrierHelper
{
  public static final int a = 0;
  public static final String a = "CarrierHelper";
  public static final boolean a = false;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 0, 2131427992, 2131427994, 2131427990, 2131427993 };
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "", "约会的推荐", "附近的群的推荐", "活动的推荐", "热聊的推荐" };
  public static final int b = 1;
  public static final String b = "carrier";
  private static final int[] b = { 0, 2130840381, 2130840398, 2130840377, 2130840419 };
  public static final int c = 2;
  public static final String c = "msglist_carrier";
  private static final int[] c = { 0, 0, 2130840399, 2130840378, 2130840420 };
  public static final int d = 0;
  private static final int[] d = { 0, 2130840384, 2130840387, 2130840386, 2130840388, 2130840389 };
  public static final int e = 1;
  public static final int f = 2;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private CarrierADView jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView;
  private List jdField_a_of_type_JavaUtilList = null;
  private int g;
  private int h = -1;
  
  public CarrierHelper(BaseActivity paramBaseActivity, View.OnClickListener paramOnClickListener, int paramInt)
  {
    if (paramBaseActivity == null) {
      throw new NullPointerException("baseActivity is null");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.g = paramInt;
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener == null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener = new hzj(this);
    }
  }
  
  public static EntranceContent a(int paramInt)
  {
    nearby_entrance_common.NearbyEntranceContent localNearbyEntranceContent = new nearby_entrance_common.NearbyEntranceContent();
    switch (paramInt)
    {
    }
    for (;;)
    {
      EntranceContent localEntranceContent = new EntranceContent();
      localEntranceContent.type = paramInt;
      localEntranceContent.content_buff = localNearbyEntranceContent.toByteArray();
      return localEntranceContent;
      localNearbyEntranceContent.str_title.set("附近的群");
      localNearbyEntranceContent.str_content.set("萌萌的粉丝群");
      localNearbyEntranceContent.str_content2.set("附近好玩的群哈");
      localNearbyEntranceContent.int32_pic_type.set(0);
      localNearbyEntranceContent.pic_url.set("");
      localNearbyEntranceContent.int64_id.set(339203627L);
      localNearbyEntranceContent.int32_id_type.set(2);
      localNearbyEntranceContent.bg_color.set("");
      localNearbyEntranceContent.txt_color.set("#FF0000");
      localNearbyEntranceContent.logo_url.set("https://3gimg.qq.com/qq_product_operations/playqq/dating/image/qq_mqq_movie_default.png");
      continue;
      localNearbyEntranceContent.str_title.set("附近的活动");
      localNearbyEntranceContent.str_content.set("春天的约会");
      localNearbyEntranceContent.str_content2.set("开会啦啦啦，一起来呀！摇一摇呀！！");
      localNearbyEntranceContent.int32_pic_type.set(1);
      localNearbyEntranceContent.pic_url.set("https://3gimg.qq.com/qq_product_operations/playqq/dating/image/qq_mqq_dine_default.png");
      localNearbyEntranceContent.int64_id.set(339203627L);
      localNearbyEntranceContent.int32_id_type.set(2);
      continue;
      localNearbyEntranceContent.str_title.set("附近的热聊");
      localNearbyEntranceContent.str_content.set("音乐与美食");
      localNearbyEntranceContent.str_content2.set("年前一起开个美食与音乐鉴赏节哦！！");
      localNearbyEntranceContent.int32_pic_type.set(1);
      localNearbyEntranceContent.pic_url.set("https://3gimg.qq.com/qq_product_operations/playqq/dating/image/qq_mqq_ktv_default.png");
      localNearbyEntranceContent.int64_id.set(1397608307L);
      localNearbyEntranceContent.int32_id_type.set(0);
      continue;
      localNearbyEntranceContent.str_title.set("广场");
      localNearbyEntranceContent.str_content.set("好玩推荐");
      localNearbyEntranceContent.str_content2.set("点击进入广场，有许多好玩的哦！！");
      localNearbyEntranceContent.int32_pic_type.set(1);
      localNearbyEntranceContent.pic_url.set("https://3gimg.qq.com/qq_product_operations/playqq/dating/image/qq_mqq_sport_default.png");
      localNearbyEntranceContent.int64_id.set(1397608307L);
      localNearbyEntranceContent.int32_id_type.set(0);
      localNearbyEntranceContent.bg_color.set("#FCAB00");
      localNearbyEntranceContent.txt_color.set("#FFFFFF");
      localNearbyEntranceContent.logo_url.set("https://3gimg.qq.com/qq_product_operations/playqq/dating/image/qq_mqq_travel_default.png");
    }
  }
  
  public View a()
  {
    return LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2130903952, null);
  }
  
  public View a(IFlingSwitch paramIFlingSwitch)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2130903953, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView = ((CarrierADView)localView.findViewById(2131297804));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView.setContentDescription(",");
    this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView.setFlingSwitch(paramIFlingSwitch);
    return localView;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView == null) || (!(paramObject instanceof Boolean)));
        if (((Boolean)paramObject).booleanValue())
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView.setVisibility(0);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView.setVisibility(8);
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView == null) || (!(paramObject instanceof Boolean)));
      if (((Boolean)paramObject).booleanValue())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView.b();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView.c();
      return;
    } while ((this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView == null) || (this.jdField_a_of_type_JavaUtilList == null) || (this.h == -1));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView.setCarrierData(this.jdField_a_of_type_JavaUtilList, this.h, this);
  }
  
  /* Error */
  public void a(View paramView, int paramInt, nearby_entrance_common.NearbyEntranceContent paramNearbyEntranceContent)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 266
    //   4: invokevirtual 230	android/view/View:findViewById	(I)Landroid/view/View;
    //   7: checkcast 268	com/tencent/image/URLImageView
    //   10: astore 16
    //   12: aload_1
    //   13: ldc_w 269
    //   16: invokevirtual 230	android/view/View:findViewById	(I)Landroid/view/View;
    //   19: checkcast 271	android/widget/ImageView
    //   22: astore 6
    //   24: aload_1
    //   25: ldc_w 272
    //   28: invokevirtual 230	android/view/View:findViewById	(I)Landroid/view/View;
    //   31: checkcast 271	android/widget/ImageView
    //   34: astore 14
    //   36: aload_1
    //   37: ldc_w 273
    //   40: invokevirtual 230	android/view/View:findViewById	(I)Landroid/view/View;
    //   43: checkcast 271	android/widget/ImageView
    //   46: astore 10
    //   48: aload_1
    //   49: ldc_w 274
    //   52: invokevirtual 230	android/view/View:findViewById	(I)Landroid/view/View;
    //   55: checkcast 276	android/widget/TextView
    //   58: astore 11
    //   60: aload_1
    //   61: ldc_w 277
    //   64: invokevirtual 230	android/view/View:findViewById	(I)Landroid/view/View;
    //   67: checkcast 276	android/widget/TextView
    //   70: astore 12
    //   72: aload_1
    //   73: ldc_w 278
    //   76: invokevirtual 230	android/view/View:findViewById	(I)Landroid/view/View;
    //   79: checkcast 276	android/widget/TextView
    //   82: astore 13
    //   84: aload_1
    //   85: ldc_w 279
    //   88: invokevirtual 230	android/view/View:findViewById	(I)Landroid/view/View;
    //   91: checkcast 271	android/widget/ImageView
    //   94: astore 9
    //   96: aload_0
    //   97: getfield 88	com/tencent/mobileqq/dating/CarrierHelper:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   100: invokevirtual 285	com/tencent/mobileqq/app/BaseActivity:getResources	()Landroid/content/res/Resources;
    //   103: astore 15
    //   105: aload_3
    //   106: getfield 141	tencent/im/nearby/entrance/nearby_entrance_common$NearbyEntranceContent:int32_pic_type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   109: invokevirtual 289	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   112: istore 4
    //   114: iload 4
    //   116: ifne +638 -> 754
    //   119: aload 6
    //   121: ldc_w 290
    //   124: invokevirtual 293	android/widget/ImageView:setImageResource	(I)V
    //   127: aload_3
    //   128: getfield 149	tencent/im/nearby/entrance/nearby_entrance_common$NearbyEntranceContent:pic_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   131: invokevirtual 296	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   134: astore 6
    //   136: aload 6
    //   138: invokestatic 302	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   141: ifne +662 -> 803
    //   144: aconst_null
    //   145: astore 8
    //   147: iload 4
    //   149: ifne +616 -> 765
    //   152: new 304	java/net/URL
    //   155: dup
    //   156: ldc 17
    //   158: aconst_null
    //   159: aload 6
    //   161: invokespecial 307	java/net/URL:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   164: astore 7
    //   166: aload 15
    //   168: ldc_w 308
    //   171: invokevirtual 314	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   174: astore 6
    //   176: aload 7
    //   178: aload 6
    //   180: aload 6
    //   182: invokestatic 319	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)Lcom/tencent/image/URLDrawable;
    //   185: astore 6
    //   187: aload 16
    //   189: getstatic 325	android/widget/ImageView$ScaleType:CENTER_CROP	Landroid/widget/ImageView$ScaleType;
    //   192: invokevirtual 329	com/tencent/image/URLImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   195: aload 16
    //   197: aload 6
    //   199: invokevirtual 333	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   202: aload_0
    //   203: getfield 92	com/tencent/mobileqq/dating/CarrierHelper:g	I
    //   206: ifne +710 -> 916
    //   209: aload_0
    //   210: getfield 88	com/tencent/mobileqq/dating/CarrierHelper:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   213: getfield 337	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   216: ldc_w 339
    //   219: ldc 60
    //   221: ldc 60
    //   223: ldc_w 341
    //   226: ldc_w 341
    //   229: iconst_1
    //   230: iconst_0
    //   231: iload_2
    //   232: invokestatic 345	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   235: ldc 60
    //   237: ldc 60
    //   239: ldc 60
    //   241: invokestatic 350	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   244: iconst_0
    //   245: istore 5
    //   247: aload_3
    //   248: getfield 166	tencent/im/nearby/entrance/nearby_entrance_common$NearbyEntranceContent:bg_color	Lcom/tencent/mobileqq/pb/PBStringField;
    //   251: invokevirtual 296	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   254: astore 6
    //   256: iload 5
    //   258: istore 4
    //   260: aload 6
    //   262: invokestatic 302	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   265: ifne +10 -> 275
    //   268: aload 6
    //   270: invokestatic 356	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   273: istore 4
    //   275: iload 4
    //   277: ifne +728 -> 1005
    //   280: iload_2
    //   281: iflt +724 -> 1005
    //   284: iload_2
    //   285: getstatic 38	com/tencent/mobileqq/dating/CarrierHelper:jdField_a_of_type_ArrayOfInt	[I
    //   288: arraylength
    //   289: if_icmpge +716 -> 1005
    //   292: aload 15
    //   294: getstatic 38	com/tencent/mobileqq/dating/CarrierHelper:jdField_a_of_type_ArrayOfInt	[I
    //   297: iload_2
    //   298: iaload
    //   299: invokevirtual 360	android/content/res/Resources:getColor	(I)I
    //   302: istore 5
    //   304: aload_1
    //   305: iload 5
    //   307: invokevirtual 363	android/view/View:setBackgroundColor	(I)V
    //   310: aload_3
    //   311: getfield 169	tencent/im/nearby/entrance/nearby_entrance_common$NearbyEntranceContent:txt_color	Lcom/tencent/mobileqq/pb/PBStringField;
    //   314: invokevirtual 296	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   317: astore 6
    //   319: iconst_0
    //   320: istore 5
    //   322: iload 5
    //   324: istore 4
    //   326: aload 6
    //   328: invokestatic 302	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   331: ifne +10 -> 341
    //   334: aload 6
    //   336: invokestatic 356	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   339: istore 4
    //   341: iload 4
    //   343: istore 5
    //   345: iload 4
    //   347: ifne +13 -> 360
    //   350: aload 15
    //   352: ldc_w 364
    //   355: invokevirtual 360	android/content/res/Resources:getColor	(I)I
    //   358: istore 5
    //   360: aload 11
    //   362: iload 5
    //   364: invokevirtual 367	android/widget/TextView:setTextColor	(I)V
    //   367: aload 12
    //   369: iload 5
    //   371: invokevirtual 367	android/widget/TextView:setTextColor	(I)V
    //   374: aload 13
    //   376: iload 5
    //   378: invokevirtual 367	android/widget/TextView:setTextColor	(I)V
    //   381: aload_3
    //   382: getfield 174	tencent/im/nearby/entrance/nearby_entrance_common$NearbyEntranceContent:logo_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   385: invokevirtual 296	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   388: astore 7
    //   390: aload 7
    //   392: invokestatic 302	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   395: ifne +692 -> 1087
    //   398: aconst_null
    //   399: astore 6
    //   401: new 304	java/net/URL
    //   404: dup
    //   405: aload 7
    //   407: invokespecial 368	java/net/URL:<init>	(Ljava/lang/String;)V
    //   410: astore 7
    //   412: new 370	android/graphics/drawable/ColorDrawable
    //   415: dup
    //   416: aload 15
    //   418: ldc_w 371
    //   421: invokevirtual 360	android/content/res/Resources:getColor	(I)I
    //   424: invokespecial 373	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   427: astore 8
    //   429: aload 7
    //   431: aload 8
    //   433: aload 8
    //   435: invokestatic 319	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)Lcom/tencent/image/URLDrawable;
    //   438: astore 7
    //   440: aload 7
    //   442: astore 6
    //   444: aload 14
    //   446: getstatic 376	android/widget/ImageView$ScaleType:CENTER_INSIDE	Landroid/widget/ImageView$ScaleType;
    //   449: invokevirtual 377	android/widget/ImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   452: aload 14
    //   454: aload 6
    //   456: invokevirtual 378	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   459: aload_3
    //   460: getfield 135	tencent/im/nearby/entrance/nearby_entrance_common$NearbyEntranceContent:str_content2	Lcom/tencent/mobileqq/pb/PBStringField;
    //   463: invokevirtual 296	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   466: astore 7
    //   468: iload_2
    //   469: iconst_1
    //   470: if_icmpne +661 -> 1131
    //   473: aload_3
    //   474: getfield 381	tencent/im/nearby/entrance/nearby_entrance_common$NearbyEntranceContent:int32_sub_pic_type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   477: invokevirtual 289	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   480: istore 5
    //   482: iload 5
    //   484: iconst_1
    //   485: if_icmplt +636 -> 1121
    //   488: iload 5
    //   490: iconst_5
    //   491: if_icmpgt +630 -> 1121
    //   494: getstatic 56	com/tencent/mobileqq/dating/CarrierHelper:d	[I
    //   497: iload 5
    //   499: iaload
    //   500: istore 4
    //   502: iload 5
    //   504: iconst_5
    //   505: if_icmpne +686 -> 1191
    //   508: aload 7
    //   510: ldc_w 383
    //   513: invokevirtual 387	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   516: astore 14
    //   518: aload 7
    //   520: astore 6
    //   522: aload 14
    //   524: arraylength
    //   525: iconst_2
    //   526: if_icmplt +113 -> 639
    //   529: aload 14
    //   531: iconst_0
    //   532: aaload
    //   533: ldc 236
    //   535: iconst_m1
    //   536: invokevirtual 390	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   539: astore 8
    //   541: aload 14
    //   543: iconst_1
    //   544: aaload
    //   545: ldc 236
    //   547: iconst_m1
    //   548: invokevirtual 390	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   551: astore 14
    //   553: aload 7
    //   555: astore 6
    //   557: aload 8
    //   559: arraylength
    //   560: iconst_5
    //   561: if_icmplt +78 -> 639
    //   564: aload 7
    //   566: astore 6
    //   568: aload 14
    //   570: arraylength
    //   571: iconst_5
    //   572: if_icmplt +67 -> 639
    //   575: aload 8
    //   577: iconst_0
    //   578: aaload
    //   579: aload 8
    //   581: iconst_1
    //   582: aaload
    //   583: aload 8
    //   585: iconst_2
    //   586: aaload
    //   587: aload 8
    //   589: iconst_3
    //   590: aaload
    //   591: aload 8
    //   593: iconst_4
    //   594: aaload
    //   595: aload 14
    //   597: iconst_0
    //   598: aaload
    //   599: aload 14
    //   601: iconst_1
    //   602: aaload
    //   603: aload 14
    //   605: iconst_2
    //   606: aaload
    //   607: aload 14
    //   609: iconst_3
    //   610: aaload
    //   611: aload 14
    //   613: iconst_4
    //   614: aaload
    //   615: invokestatic 395	com/tencent/mobileqq/dating/DatingUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   618: astore 6
    //   620: aload_0
    //   621: getfield 88	com/tencent/mobileqq/dating/CarrierHelper:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   624: aload 13
    //   626: invokevirtual 399	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   629: sipush 131
    //   632: aload 6
    //   634: invokestatic 402	com/tencent/mobileqq/dating/DatingUtil:a	(Landroid/content/Context;Landroid/graphics/Paint;ILjava/lang/String;)Ljava/lang/String;
    //   637: astore 6
    //   639: iload 4
    //   641: ifne +526 -> 1167
    //   644: aload 10
    //   646: bipush 8
    //   648: invokevirtual 403	android/widget/ImageView:setVisibility	(I)V
    //   651: aload 10
    //   653: aconst_null
    //   654: invokevirtual 378	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   657: aload 11
    //   659: aload_3
    //   660: getfield 120	tencent/im/nearby/entrance/nearby_entrance_common$NearbyEntranceContent:str_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   663: invokevirtual 296	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   666: invokevirtual 406	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   669: aload 12
    //   671: aload_3
    //   672: getfield 130	tencent/im/nearby/entrance/nearby_entrance_common$NearbyEntranceContent:str_content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   675: invokevirtual 296	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   678: invokevirtual 406	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   681: aload 13
    //   683: aload 6
    //   685: invokevirtual 406	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   688: iload_2
    //   689: iflt +494 -> 1183
    //   692: iload_2
    //   693: getstatic 70	com/tencent/mobileqq/dating/CarrierHelper:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   696: arraylength
    //   697: if_icmpge +486 -> 1183
    //   700: getstatic 70	com/tencent/mobileqq/dating/CarrierHelper:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   703: iload_2
    //   704: aaload
    //   705: astore 6
    //   707: aload_1
    //   708: aload 6
    //   710: invokevirtual 407	android/view/View:setContentDescription	(Ljava/lang/CharSequence;)V
    //   713: aload 9
    //   715: aload 6
    //   717: invokevirtual 408	android/widget/ImageView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   720: aload 9
    //   722: aload_3
    //   723: getfield 411	tencent/im/nearby/entrance/nearby_entrance_common$NearbyEntranceContent:str_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   726: invokevirtual 296	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   729: invokevirtual 415	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   732: aload 9
    //   734: ldc_w 416
    //   737: iload_2
    //   738: invokestatic 421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   741: invokevirtual 423	android/widget/ImageView:setTag	(ILjava/lang/Object;)V
    //   744: aload 9
    //   746: aload_0
    //   747: getfield 90	com/tencent/mobileqq/dating/CarrierHelper:jdField_a_of_type_AndroidViewView$OnClickListener	Landroid/view/View$OnClickListener;
    //   750: invokevirtual 427	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   753: return
    //   754: aload 6
    //   756: ldc_w 428
    //   759: invokevirtual 293	android/widget/ImageView:setImageResource	(I)V
    //   762: goto -635 -> 127
    //   765: new 304	java/net/URL
    //   768: dup
    //   769: aload 6
    //   771: invokespecial 368	java/net/URL:<init>	(Ljava/lang/String;)V
    //   774: astore 7
    //   776: aload 15
    //   778: ldc_w 429
    //   781: invokevirtual 314	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   784: astore 6
    //   786: goto -610 -> 176
    //   789: astore 6
    //   791: aload 6
    //   793: invokevirtual 432	java/lang/Exception:printStackTrace	()V
    //   796: aload 8
    //   798: astore 6
    //   800: goto -613 -> 187
    //   803: aload_3
    //   804: getfield 163	tencent/im/nearby/entrance/nearby_entrance_common$NearbyEntranceContent:int32_id_type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   807: invokevirtual 289	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   810: istore 4
    //   812: aload_3
    //   813: getfield 153	tencent/im/nearby/entrance/nearby_entrance_common$NearbyEntranceContent:int64_id	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   816: invokevirtual 435	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   819: invokestatic 438	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   822: astore 6
    //   824: iload 4
    //   826: ifne +31 -> 857
    //   829: aload_0
    //   830: getfield 88	com/tencent/mobileqq/dating/CarrierHelper:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   833: getfield 337	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   836: sipush 3000
    //   839: aload 6
    //   841: iconst_1
    //   842: invokestatic 443	com/tencent/mobileqq/util/FaceDrawable:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILjava/lang/String;Z)Lcom/tencent/mobileqq/util/FaceDrawable;
    //   845: astore 6
    //   847: aload 16
    //   849: aload 6
    //   851: invokevirtual 333	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   854: goto -652 -> 202
    //   857: iload 4
    //   859: iconst_1
    //   860: if_icmpne +24 -> 884
    //   863: aload_0
    //   864: getfield 88	com/tencent/mobileqq/dating/CarrierHelper:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   867: getfield 337	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   870: sipush 3001
    //   873: aload 6
    //   875: iconst_1
    //   876: invokestatic 443	com/tencent/mobileqq/util/FaceDrawable:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILjava/lang/String;Z)Lcom/tencent/mobileqq/util/FaceDrawable;
    //   879: astore 6
    //   881: goto -34 -> 847
    //   884: iload 4
    //   886: iconst_2
    //   887: if_icmpne +21 -> 908
    //   890: aload_0
    //   891: getfield 88	com/tencent/mobileqq/dating/CarrierHelper:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   894: getfield 337	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   897: iconst_4
    //   898: aload 6
    //   900: invokestatic 446	com/tencent/mobileqq/util/FaceDrawable:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILjava/lang/String;)Lcom/tencent/mobileqq/util/FaceDrawable;
    //   903: astore 6
    //   905: goto -58 -> 847
    //   908: invokestatic 451	com/tencent/mobileqq/utils/ImageUtil:b	()Landroid/graphics/drawable/Drawable;
    //   911: astore 6
    //   913: goto -66 -> 847
    //   916: aload_0
    //   917: getfield 92	com/tencent/mobileqq/dating/CarrierHelper:g	I
    //   920: iconst_2
    //   921: if_icmpeq +11 -> 932
    //   924: aload_0
    //   925: getfield 92	com/tencent/mobileqq/dating/CarrierHelper:g	I
    //   928: iconst_1
    //   929: if_icmpne -685 -> 244
    //   932: aload_0
    //   933: getfield 88	com/tencent/mobileqq/dating/CarrierHelper:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   936: getfield 337	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   939: ldc_w 339
    //   942: ldc 60
    //   944: ldc 60
    //   946: ldc_w 453
    //   949: ldc_w 453
    //   952: aload_0
    //   953: getfield 92	com/tencent/mobileqq/dating/CarrierHelper:g	I
    //   956: iconst_0
    //   957: iload_2
    //   958: invokestatic 345	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   961: ldc 60
    //   963: ldc 60
    //   965: ldc 60
    //   967: invokestatic 350	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   970: goto -726 -> 244
    //   973: astore 6
    //   975: ldc 10
    //   977: iconst_2
    //   978: anewarray 4	java/lang/Object
    //   981: dup
    //   982: iconst_0
    //   983: ldc_w 455
    //   986: aastore
    //   987: dup
    //   988: iconst_1
    //   989: aload 6
    //   991: invokevirtual 458	java/lang/Exception:toString	()Ljava/lang/String;
    //   994: aastore
    //   995: invokestatic 461	com/tencent/mobileqq/dating/DatingUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   998: iload 5
    //   1000: istore 4
    //   1002: goto -727 -> 275
    //   1005: iload 4
    //   1007: istore 5
    //   1009: iload 4
    //   1011: ifne -707 -> 304
    //   1014: aload 15
    //   1016: ldc_w 462
    //   1019: invokevirtual 360	android/content/res/Resources:getColor	(I)I
    //   1022: istore 5
    //   1024: goto -720 -> 304
    //   1027: astore 6
    //   1029: ldc 10
    //   1031: iconst_2
    //   1032: anewarray 4	java/lang/Object
    //   1035: dup
    //   1036: iconst_0
    //   1037: ldc_w 455
    //   1040: aastore
    //   1041: dup
    //   1042: iconst_1
    //   1043: aload 6
    //   1045: invokevirtual 458	java/lang/Exception:toString	()Ljava/lang/String;
    //   1048: aastore
    //   1049: invokestatic 461	com/tencent/mobileqq/dating/DatingUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1052: iload 5
    //   1054: istore 4
    //   1056: goto -715 -> 341
    //   1059: astore 7
    //   1061: ldc 10
    //   1063: iconst_2
    //   1064: anewarray 4	java/lang/Object
    //   1067: dup
    //   1068: iconst_0
    //   1069: ldc_w 455
    //   1072: aastore
    //   1073: dup
    //   1074: iconst_1
    //   1075: aload 7
    //   1077: invokevirtual 458	java/lang/Exception:toString	()Ljava/lang/String;
    //   1080: aastore
    //   1081: invokestatic 461	com/tencent/mobileqq/dating/DatingUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1084: goto -640 -> 444
    //   1087: iload_2
    //   1088: iflt +24 -> 1112
    //   1091: iload_2
    //   1092: getstatic 44	com/tencent/mobileqq/dating/CarrierHelper:b	[I
    //   1095: arraylength
    //   1096: if_icmpge +16 -> 1112
    //   1099: aload 14
    //   1101: getstatic 44	com/tencent/mobileqq/dating/CarrierHelper:b	[I
    //   1104: iload_2
    //   1105: iaload
    //   1106: invokevirtual 293	android/widget/ImageView:setImageResource	(I)V
    //   1109: goto -650 -> 459
    //   1112: aload 14
    //   1114: aconst_null
    //   1115: invokevirtual 378	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1118: goto -659 -> 459
    //   1121: iconst_0
    //   1122: istore 4
    //   1124: aload 7
    //   1126: astore 6
    //   1128: goto -489 -> 639
    //   1131: iload_2
    //   1132: iflt +25 -> 1157
    //   1135: iload_2
    //   1136: getstatic 49	com/tencent/mobileqq/dating/CarrierHelper:c	[I
    //   1139: arraylength
    //   1140: if_icmpge +17 -> 1157
    //   1143: getstatic 49	com/tencent/mobileqq/dating/CarrierHelper:c	[I
    //   1146: iload_2
    //   1147: iaload
    //   1148: istore 4
    //   1150: aload 7
    //   1152: astore 6
    //   1154: goto -515 -> 639
    //   1157: iconst_0
    //   1158: istore 4
    //   1160: aload 7
    //   1162: astore 6
    //   1164: goto -525 -> 639
    //   1167: aload 10
    //   1169: iconst_0
    //   1170: invokevirtual 403	android/widget/ImageView:setVisibility	(I)V
    //   1173: aload 10
    //   1175: iload 4
    //   1177: invokevirtual 293	android/widget/ImageView:setImageResource	(I)V
    //   1180: goto -523 -> 657
    //   1183: ldc_w 464
    //   1186: astore 6
    //   1188: goto -481 -> 707
    //   1191: aload 7
    //   1193: astore 6
    //   1195: goto -556 -> 639
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1198	0	this	CarrierHelper
    //   0	1198	1	paramView	View
    //   0	1198	2	paramInt	int
    //   0	1198	3	paramNearbyEntranceContent	nearby_entrance_common.NearbyEntranceContent
    //   112	1064	4	i	int
    //   245	808	5	j	int
    //   22	763	6	localObject1	Object
    //   789	3	6	localException1	java.lang.Exception
    //   798	114	6	localObject2	Object
    //   973	17	6	localException2	java.lang.Exception
    //   1027	17	6	localException3	java.lang.Exception
    //   1126	68	6	localObject3	Object
    //   164	611	7	localObject4	Object
    //   1059	133	7	localException4	java.lang.Exception
    //   145	652	8	localObject5	Object
    //   94	651	9	localImageView1	android.widget.ImageView
    //   46	1128	10	localImageView2	android.widget.ImageView
    //   58	600	11	localTextView1	android.widget.TextView
    //   70	600	12	localTextView2	android.widget.TextView
    //   82	600	13	localTextView3	android.widget.TextView
    //   34	1079	14	localObject6	Object
    //   103	912	15	localResources	android.content.res.Resources
    //   10	838	16	localURLImageView	com.tencent.image.URLImageView
    // Exception table:
    //   from	to	target	type
    //   152	176	789	java/lang/Exception
    //   176	187	789	java/lang/Exception
    //   765	786	789	java/lang/Exception
    //   268	275	973	java/lang/Exception
    //   334	341	1027	java/lang/Exception
    //   401	440	1059	java/lang/Exception
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: new 468	java/io/ObjectInputStream
    //   3: dup
    //   4: new 470	java/io/BufferedInputStream
    //   7: dup
    //   8: aload_0
    //   9: getfield 88	com/tencent/mobileqq/dating/CarrierHelper:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   12: aload_1
    //   13: invokevirtual 474	com/tencent/mobileqq/app/BaseActivity:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   16: invokespecial 477	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   19: invokespecial 478	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   22: astore_2
    //   23: aload_2
    //   24: astore_1
    //   25: aload_0
    //   26: aload_2
    //   27: invokevirtual 482	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   30: checkcast 484	java/util/List
    //   33: putfield 79	com/tencent/mobileqq/dating/CarrierHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   36: aload_2
    //   37: astore_1
    //   38: aload_0
    //   39: getfield 79	com/tencent/mobileqq/dating/CarrierHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   42: ifnull +13 -> 55
    //   45: aload_2
    //   46: astore_1
    //   47: aload_0
    //   48: aload_2
    //   49: invokevirtual 487	java/io/ObjectInputStream:readInt	()I
    //   52: putfield 77	com/tencent/mobileqq/dating/CarrierHelper:h	I
    //   55: aload_2
    //   56: ifnull +7 -> 63
    //   59: aload_2
    //   60: invokevirtual 490	java/io/ObjectInputStream:close	()V
    //   63: return
    //   64: astore_1
    //   65: invokestatic 495	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq -5 -> 63
    //   71: ldc_w 497
    //   74: iconst_2
    //   75: new 499	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 500	java/lang/StringBuilder:<init>	()V
    //   82: ldc_w 502
    //   85: invokevirtual 506	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_1
    //   89: invokevirtual 509	java/io/IOException:getMessage	()Ljava/lang/String;
    //   92: invokevirtual 506	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 510	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 513	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: return
    //   102: astore_3
    //   103: aconst_null
    //   104: astore_2
    //   105: aload_2
    //   106: astore_1
    //   107: invokestatic 495	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   110: ifeq +35 -> 145
    //   113: aload_2
    //   114: astore_1
    //   115: ldc_w 497
    //   118: iconst_2
    //   119: new 499	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 500	java/lang/StringBuilder:<init>	()V
    //   126: ldc_w 515
    //   129: invokevirtual 506	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload_3
    //   133: invokevirtual 516	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   136: invokevirtual 506	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 510	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 513	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: aload_2
    //   146: ifnull -83 -> 63
    //   149: aload_2
    //   150: invokevirtual 490	java/io/ObjectInputStream:close	()V
    //   153: return
    //   154: astore_1
    //   155: invokestatic 495	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq -95 -> 63
    //   161: ldc_w 497
    //   164: iconst_2
    //   165: new 499	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 500	java/lang/StringBuilder:<init>	()V
    //   172: ldc_w 502
    //   175: invokevirtual 506	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload_1
    //   179: invokevirtual 509	java/io/IOException:getMessage	()Ljava/lang/String;
    //   182: invokevirtual 506	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 510	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 513	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: return
    //   192: astore_2
    //   193: aconst_null
    //   194: astore_1
    //   195: aload_1
    //   196: ifnull +7 -> 203
    //   199: aload_1
    //   200: invokevirtual 490	java/io/ObjectInputStream:close	()V
    //   203: aload_2
    //   204: athrow
    //   205: astore_1
    //   206: invokestatic 495	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   209: ifeq -6 -> 203
    //   212: ldc_w 497
    //   215: iconst_2
    //   216: new 499	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 500	java/lang/StringBuilder:<init>	()V
    //   223: ldc_w 502
    //   226: invokevirtual 506	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload_1
    //   230: invokevirtual 509	java/io/IOException:getMessage	()Ljava/lang/String;
    //   233: invokevirtual 506	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 510	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 513	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   242: goto -39 -> 203
    //   245: astore_2
    //   246: goto -51 -> 195
    //   249: astore_3
    //   250: goto -145 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	CarrierHelper
    //   0	253	1	paramString	String
    //   22	128	2	localObjectInputStream	java.io.ObjectInputStream
    //   192	12	2	localObject1	Object
    //   245	1	2	localObject2	Object
    //   102	31	3	localException1	java.lang.Exception
    //   249	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   59	63	64	java/io/IOException
    //   0	23	102	java/lang/Exception
    //   149	153	154	java/io/IOException
    //   0	23	192	finally
    //   199	203	205	java/io/IOException
    //   25	36	245	finally
    //   38	45	245	finally
    //   47	55	245	finally
    //   107	113	245	finally
    //   115	145	245	finally
    //   25	36	249	java/lang/Exception
    //   38	45	249	java/lang/Exception
    //   47	55	249	java/lang/Exception
  }
  
  public void a(List paramList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.h = paramInt;
  }
  
  /* Error */
  public void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 79	com/tencent/mobileqq/dating/CarrierHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   4: ifnull +17 -> 21
    //   7: aload_0
    //   8: getfield 234	com/tencent/mobileqq/dating/CarrierHelper:jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView	Lcom/tencent/mobileqq/widget/CarrierADView;
    //   11: ifnull +10 -> 21
    //   14: aload_1
    //   15: invokestatic 302	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +4 -> 22
    //   21: return
    //   22: aload_0
    //   23: getfield 234	com/tencent/mobileqq/dating/CarrierHelper:jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView	Lcom/tencent/mobileqq/widget/CarrierADView;
    //   26: invokevirtual 519	com/tencent/mobileqq/widget/CarrierADView:a	()I
    //   29: istore_2
    //   30: new 521	java/io/ObjectOutputStream
    //   33: dup
    //   34: new 523	java/io/BufferedOutputStream
    //   37: dup
    //   38: aload_0
    //   39: getfield 88	com/tencent/mobileqq/dating/CarrierHelper:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   42: aload_1
    //   43: iconst_0
    //   44: invokevirtual 527	com/tencent/mobileqq/app/BaseActivity:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   47: invokespecial 530	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   50: invokespecial 531	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   53: astore_3
    //   54: aload_3
    //   55: astore_1
    //   56: aload_3
    //   57: aload_0
    //   58: getfield 79	com/tencent/mobileqq/dating/CarrierHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   61: invokevirtual 534	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   64: aload_3
    //   65: astore_1
    //   66: aload_3
    //   67: iload_2
    //   68: invokevirtual 537	java/io/ObjectOutputStream:writeInt	(I)V
    //   71: aload_3
    //   72: astore_1
    //   73: aload_3
    //   74: invokevirtual 540	java/io/ObjectOutputStream:flush	()V
    //   77: aload_3
    //   78: ifnull -57 -> 21
    //   81: aload_3
    //   82: invokevirtual 541	java/io/ObjectOutputStream:close	()V
    //   85: return
    //   86: astore_1
    //   87: invokestatic 495	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq -69 -> 21
    //   93: ldc_w 497
    //   96: iconst_2
    //   97: new 499	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 500	java/lang/StringBuilder:<init>	()V
    //   104: ldc_w 502
    //   107: invokevirtual 506	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_1
    //   111: invokevirtual 509	java/io/IOException:getMessage	()Ljava/lang/String;
    //   114: invokevirtual 506	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 510	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 513	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: return
    //   124: astore 4
    //   126: aconst_null
    //   127: astore_3
    //   128: aload_3
    //   129: astore_1
    //   130: invokestatic 495	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +36 -> 169
    //   136: aload_3
    //   137: astore_1
    //   138: ldc_w 497
    //   141: iconst_2
    //   142: new 499	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 500	java/lang/StringBuilder:<init>	()V
    //   149: ldc_w 515
    //   152: invokevirtual 506	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload 4
    //   157: invokevirtual 516	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   160: invokevirtual 506	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 510	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 513	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: aload_3
    //   170: ifnull -149 -> 21
    //   173: aload_3
    //   174: invokevirtual 541	java/io/ObjectOutputStream:close	()V
    //   177: return
    //   178: astore_1
    //   179: invokestatic 495	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   182: ifeq -161 -> 21
    //   185: ldc_w 497
    //   188: iconst_2
    //   189: new 499	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 500	java/lang/StringBuilder:<init>	()V
    //   196: ldc_w 502
    //   199: invokevirtual 506	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload_1
    //   203: invokevirtual 509	java/io/IOException:getMessage	()Ljava/lang/String;
    //   206: invokevirtual 506	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 510	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 513	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   215: return
    //   216: astore_3
    //   217: aconst_null
    //   218: astore_1
    //   219: aload_1
    //   220: ifnull +7 -> 227
    //   223: aload_1
    //   224: invokevirtual 541	java/io/ObjectOutputStream:close	()V
    //   227: aload_3
    //   228: athrow
    //   229: astore_1
    //   230: invokestatic 495	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   233: ifeq -6 -> 227
    //   236: ldc_w 497
    //   239: iconst_2
    //   240: new 499	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 500	java/lang/StringBuilder:<init>	()V
    //   247: ldc_w 502
    //   250: invokevirtual 506	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload_1
    //   254: invokevirtual 509	java/io/IOException:getMessage	()Ljava/lang/String;
    //   257: invokevirtual 506	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: invokevirtual 510	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokestatic 513	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   266: goto -39 -> 227
    //   269: astore_3
    //   270: goto -51 -> 219
    //   273: astore 4
    //   275: goto -147 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	this	CarrierHelper
    //   0	278	1	paramString	String
    //   29	39	2	i	int
    //   53	121	3	localObjectOutputStream	java.io.ObjectOutputStream
    //   216	12	3	localObject1	Object
    //   269	1	3	localObject2	Object
    //   124	32	4	localException1	java.lang.Exception
    //   273	1	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   81	85	86	java/io/IOException
    //   30	54	124	java/lang/Exception
    //   173	177	178	java/io/IOException
    //   30	54	216	finally
    //   223	227	229	java/io/IOException
    //   56	64	269	finally
    //   66	71	269	finally
    //   73	77	269	finally
    //   130	136	269	finally
    //   138	169	269	finally
    //   56	64	273	java/lang/Exception
    //   66	71	273	java/lang/Exception
    //   73	77	273	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.CarrierHelper
 * JD-Core Version:    0.7.0.1
 */