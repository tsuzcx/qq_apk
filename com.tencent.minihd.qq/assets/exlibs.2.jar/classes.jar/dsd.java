import android.os.Handler.Callback;
import com.tencent.mobileqq.activity.Conversation;

public class dsd
  implements Handler.Callback
{
  public dsd(Conversation paramConversation) {}
  
  /* Error */
  public boolean handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: iconst_2
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_3
    //   4: aload_1
    //   5: getfield 26	android/os/Message:what	I
    //   8: ldc 27
    //   10: if_icmpne +16 -> 26
    //   13: aload_0
    //   14: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   17: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   20: bipush 7
    //   22: iconst_0
    //   23: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   26: aload_1
    //   27: getfield 26	android/os/Message:what	I
    //   30: ldc 38
    //   32: if_icmpeq +18 -> 50
    //   35: aload_0
    //   36: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   39: getfield 42	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   42: invokevirtual 48	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   45: ifne +5 -> 50
    //   48: iconst_1
    //   49: ireturn
    //   50: aload_1
    //   51: getfield 26	android/os/Message:what	I
    //   54: lookupswitch	default:+314->368, 1009:+325->379, 1010:+440->494, 1014:+1120->1174, 1016:+1130->1184, 1017:+1161->1215, 1019:+1569->1623, 1020:+1171->1225, 1023:+505->559, 1025:+316->370, 1030:+1588->1642, 1031:+1691->1745, 1032:+1068->1122, 1033:+1094->1148, 1034:+-6->48, 1035:+-6->48, 1036:+1702->1756, 1037:+1767->1821, 10000:+1262->1316, 10001:+349->403, 10002:+416->470, 1134010:+704->758, 1134011:+730->784, 1134012:+879->933, 1134013:+930->984, 1134014:+998->1052, 1134015:+836->890, 1134018:+548->602, 1134019:+587->641, 1134020:+668->722, 1134021:+756->810, 1134022:+781->835, 1134024:+806->860, 1134025:+1597->1651, 1134026:+1647->1701, 11340003:+522->576, 11340004:+678->732, 11340006:+1016->1070, 11340007:+1042->1096
    //   369: ireturn
    //   370: aload_0
    //   371: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   374: invokestatic 50	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   377: iconst_1
    //   378: ireturn
    //   379: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   382: ifeq +11 -> 393
    //   385: ldc 57
    //   387: iconst_2
    //   388: ldc 59
    //   390: invokestatic 63	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   393: aload_0
    //   394: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   397: lconst_0
    //   398: invokevirtual 66	com/tencent/mobileqq/activity/Conversation:a	(J)V
    //   401: iconst_1
    //   402: ireturn
    //   403: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   406: ifeq +11 -> 417
    //   409: ldc 57
    //   411: iconst_2
    //   412: ldc 68
    //   414: invokestatic 63	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: aload_0
    //   418: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   421: aload_1
    //   422: invokevirtual 71	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;)V
    //   425: aload_0
    //   426: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   429: iconst_1
    //   430: invokestatic 74	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Z)V
    //   433: invokestatic 77	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   436: ifeq -388 -> 48
    //   439: ldc 57
    //   441: iconst_4
    //   442: new 79	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   449: ldc 82
    //   451: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: invokestatic 92	java/lang/System:currentTimeMillis	()J
    //   457: lconst_0
    //   458: lsub
    //   459: invokevirtual 95	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   462: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: invokestatic 63	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   468: iconst_1
    //   469: ireturn
    //   470: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   473: ifeq +11 -> 484
    //   476: ldc 57
    //   478: iconst_2
    //   479: ldc 101
    //   481: invokestatic 63	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   484: aload_0
    //   485: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   488: aload_1
    //   489: invokevirtual 71	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;)V
    //   492: iconst_1
    //   493: ireturn
    //   494: aload_0
    //   495: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   498: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   501: invokevirtual 103	com/tencent/mobileqq/activity/recent/BannerManager:a	()Z
    //   504: ifeq +29 -> 533
    //   507: aload_0
    //   508: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   511: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   514: bipush 13
    //   516: iconst_2
    //   517: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   520: aload_0
    //   521: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   524: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   527: aload_1
    //   528: invokevirtual 104	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   531: iconst_1
    //   532: ireturn
    //   533: aload_0
    //   534: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   537: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   540: bipush 13
    //   542: iconst_0
    //   543: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   546: aload_0
    //   547: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   550: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   553: aconst_null
    //   554: invokevirtual 104	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   557: iconst_1
    //   558: ireturn
    //   559: invokestatic 110	com/tencent/mobileqq/app/ThreadManager:b	()Landroid/os/Handler;
    //   562: new 112	dse
    //   565: dup
    //   566: aload_0
    //   567: invokespecial 115	dse:<init>	(Ldsd;)V
    //   570: invokevirtual 121	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   573: pop
    //   574: iconst_1
    //   575: ireturn
    //   576: aload_0
    //   577: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   580: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   583: bipush 7
    //   585: iconst_2
    //   586: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   589: aload_0
    //   590: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   593: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   596: aload_1
    //   597: invokevirtual 104	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   600: iconst_1
    //   601: ireturn
    //   602: aload_0
    //   603: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   606: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   609: bipush 9
    //   611: iconst_2
    //   612: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   615: aload_0
    //   616: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   619: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   622: bipush 7
    //   624: iconst_0
    //   625: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   628: aload_0
    //   629: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   632: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   635: aload_1
    //   636: invokevirtual 104	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   639: iconst_1
    //   640: ireturn
    //   641: aload_0
    //   642: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   645: invokestatic 124	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   648: ifnull +22 -> 670
    //   651: aload_0
    //   652: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   655: invokestatic 124	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   658: invokevirtual 129	com/tencent/mobileqq/activity/UpgradeTipsDialog:dismiss	()V
    //   661: aload_0
    //   662: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   665: aconst_null
    //   666: invokestatic 132	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   669: pop
    //   670: aload_0
    //   671: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   674: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   677: bipush 9
    //   679: iconst_0
    //   680: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   683: aload_0
    //   684: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   687: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   690: aload_1
    //   691: invokevirtual 104	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   694: iconst_1
    //   695: ireturn
    //   696: astore 6
    //   698: aload_0
    //   699: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   702: aconst_null
    //   703: invokestatic 132	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   706: pop
    //   707: goto -37 -> 670
    //   710: astore_1
    //   711: aload_0
    //   712: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   715: aconst_null
    //   716: invokestatic 132	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   719: pop
    //   720: aload_1
    //   721: athrow
    //   722: aload_0
    //   723: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   726: aload_1
    //   727: invokestatic 135	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Landroid/os/Message;)V
    //   730: iconst_1
    //   731: ireturn
    //   732: aload_0
    //   733: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   736: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   739: bipush 7
    //   741: iconst_0
    //   742: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   745: aload_0
    //   746: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   749: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   752: aload_1
    //   753: invokevirtual 104	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   756: iconst_1
    //   757: ireturn
    //   758: aload_0
    //   759: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   762: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   765: bipush 17
    //   767: iconst_2
    //   768: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   771: aload_0
    //   772: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   775: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   778: aload_1
    //   779: invokevirtual 104	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   782: iconst_1
    //   783: ireturn
    //   784: aload_0
    //   785: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   788: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   791: bipush 17
    //   793: iconst_0
    //   794: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   797: aload_0
    //   798: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   801: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   804: aload_1
    //   805: invokevirtual 104	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   808: iconst_1
    //   809: ireturn
    //   810: aload_0
    //   811: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   814: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   817: iconst_3
    //   818: iconst_2
    //   819: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   822: aload_0
    //   823: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   826: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   829: aload_1
    //   830: invokevirtual 104	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   833: iconst_1
    //   834: ireturn
    //   835: aload_0
    //   836: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   839: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   842: iconst_3
    //   843: iconst_0
    //   844: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   847: aload_0
    //   848: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   851: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   854: aload_1
    //   855: invokevirtual 104	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   858: iconst_1
    //   859: ireturn
    //   860: aload_1
    //   861: getfield 138	android/os/Message:arg1	I
    //   864: istore_2
    //   865: aload_0
    //   866: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   869: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   872: iconst_4
    //   873: iload_2
    //   874: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   877: aload_0
    //   878: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   881: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   884: aload_1
    //   885: invokevirtual 104	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   888: iconst_1
    //   889: ireturn
    //   890: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   893: ifeq +11 -> 904
    //   896: ldc 57
    //   898: iconst_2
    //   899: ldc 140
    //   901: invokestatic 63	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   904: aload_0
    //   905: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   908: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   911: iconst_5
    //   912: iconst_0
    //   913: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   916: invokestatic 145	com/tencent/mobileqq/managers/LoadingStateManager:a	()Lcom/tencent/mobileqq/managers/LoadingStateManager;
    //   919: iconst_0
    //   920: invokevirtual 148	com/tencent/mobileqq/managers/LoadingStateManager:b	(Z)V
    //   923: aload_0
    //   924: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   927: aload_1
    //   928: invokevirtual 71	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;)V
    //   931: iconst_1
    //   932: ireturn
    //   933: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   936: ifeq +11 -> 947
    //   939: ldc 57
    //   941: iconst_2
    //   942: ldc 150
    //   944: invokestatic 63	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   947: aload_0
    //   948: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   951: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   954: iconst_5
    //   955: iconst_0
    //   956: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   959: invokestatic 145	com/tencent/mobileqq/managers/LoadingStateManager:a	()Lcom/tencent/mobileqq/managers/LoadingStateManager;
    //   962: iconst_0
    //   963: invokevirtual 148	com/tencent/mobileqq/managers/LoadingStateManager:b	(Z)V
    //   966: aload_0
    //   967: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   970: aload_1
    //   971: invokevirtual 71	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;)V
    //   974: aload_0
    //   975: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   978: iconst_1
    //   979: invokestatic 74	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Z)V
    //   982: iconst_1
    //   983: ireturn
    //   984: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   987: ifeq +11 -> 998
    //   990: ldc 57
    //   992: iconst_2
    //   993: ldc 152
    //   995: invokestatic 63	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   998: aload_0
    //   999: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1002: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1005: iconst_5
    //   1006: invokevirtual 155	com/tencent/mobileqq/activity/recent/BannerManager:a	(I)Z
    //   1009: ifne +26 -> 1035
    //   1012: aload_0
    //   1013: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1016: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1019: iconst_5
    //   1020: iconst_2
    //   1021: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1024: aload_0
    //   1025: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1028: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1031: aload_1
    //   1032: invokevirtual 104	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   1035: invokestatic 145	com/tencent/mobileqq/managers/LoadingStateManager:a	()Lcom/tencent/mobileqq/managers/LoadingStateManager;
    //   1038: iconst_1
    //   1039: invokevirtual 148	com/tencent/mobileqq/managers/LoadingStateManager:b	(Z)V
    //   1042: aload_0
    //   1043: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1046: iconst_1
    //   1047: invokestatic 74	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Z)V
    //   1050: iconst_1
    //   1051: ireturn
    //   1052: aload_0
    //   1053: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1056: aconst_null
    //   1057: invokevirtual 71	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;)V
    //   1060: aload_0
    //   1061: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1064: iconst_1
    //   1065: invokestatic 74	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Z)V
    //   1068: iconst_1
    //   1069: ireturn
    //   1070: aload_0
    //   1071: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1074: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1077: bipush 13
    //   1079: iconst_0
    //   1080: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1083: aload_0
    //   1084: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1087: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1090: aload_1
    //   1091: invokevirtual 104	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   1094: iconst_1
    //   1095: ireturn
    //   1096: aload_0
    //   1097: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1100: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1103: bipush 13
    //   1105: iconst_2
    //   1106: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1109: aload_0
    //   1110: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1113: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1116: aload_1
    //   1117: invokevirtual 104	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   1120: iconst_1
    //   1121: ireturn
    //   1122: aload_0
    //   1123: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1126: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1129: bipush 14
    //   1131: iconst_2
    //   1132: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1135: aload_0
    //   1136: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1139: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1142: aload_1
    //   1143: invokevirtual 104	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   1146: iconst_1
    //   1147: ireturn
    //   1148: aload_0
    //   1149: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1152: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1155: bipush 14
    //   1157: iconst_0
    //   1158: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1161: aload_0
    //   1162: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1165: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1168: aload_1
    //   1169: invokevirtual 104	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   1172: iconst_1
    //   1173: ireturn
    //   1174: aload_0
    //   1175: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1178: lconst_0
    //   1179: invokevirtual 66	com/tencent/mobileqq/activity/Conversation:a	(J)V
    //   1182: iconst_1
    //   1183: ireturn
    //   1184: aload_0
    //   1185: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1188: iconst_0
    //   1189: invokestatic 158	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Z)Z
    //   1192: pop
    //   1193: aload_0
    //   1194: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1197: invokestatic 161	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   1200: ifnull -1152 -> 48
    //   1203: aload_0
    //   1204: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1207: invokestatic 161	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   1210: invokevirtual 166	com/tencent/mobileqq/fpsreport/FPSSwipListView:B	()V
    //   1213: iconst_1
    //   1214: ireturn
    //   1215: aload_0
    //   1216: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1219: lconst_0
    //   1220: invokevirtual 66	com/tencent/mobileqq/activity/Conversation:a	(J)V
    //   1223: iconst_1
    //   1224: ireturn
    //   1225: aload_1
    //   1226: getfield 138	android/os/Message:arg1	I
    //   1229: ifne +51 -> 1280
    //   1232: invokestatic 110	com/tencent/mobileqq/app/ThreadManager:b	()Landroid/os/Handler;
    //   1235: new 168	dsg
    //   1238: dup
    //   1239: aload_0
    //   1240: invokespecial 169	dsg:<init>	(Ldsd;)V
    //   1243: invokevirtual 121	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   1246: pop
    //   1247: invokestatic 173	android/os/Message:obtain	()Landroid/os/Message;
    //   1250: astore_1
    //   1251: aload_1
    //   1252: sipush 1020
    //   1255: putfield 26	android/os/Message:what	I
    //   1258: aload_1
    //   1259: iconst_1
    //   1260: putfield 138	android/os/Message:arg1	I
    //   1263: aload_0
    //   1264: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1267: getfield 176	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1270: aload_1
    //   1271: ldc2_w 177
    //   1274: invokevirtual 182	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   1277: pop
    //   1278: iconst_1
    //   1279: ireturn
    //   1280: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1283: ifeq +11 -> 1294
    //   1286: ldc 57
    //   1288: iconst_2
    //   1289: ldc 184
    //   1291: invokestatic 63	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1294: aload_0
    //   1295: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1298: getfield 176	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1301: sipush 1020
    //   1304: invokevirtual 188	android/os/Handler:removeMessages	(I)V
    //   1307: aload_0
    //   1308: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1311: invokevirtual 191	com/tencent/mobileqq/activity/Conversation:f	()V
    //   1314: iconst_1
    //   1315: ireturn
    //   1316: invokestatic 92	java/lang/System:currentTimeMillis	()J
    //   1319: aload_0
    //   1320: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1323: invokestatic 194	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)J
    //   1326: lsub
    //   1327: invokestatic 200	java/lang/Math:abs	(J)J
    //   1330: lstore 4
    //   1332: invokestatic 77	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1335: ifeq +46 -> 1381
    //   1338: ldc 57
    //   1340: iconst_4
    //   1341: new 79	java/lang/StringBuilder
    //   1344: dup
    //   1345: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1348: ldc 202
    //   1350: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1353: aload_1
    //   1354: getfield 138	android/os/Message:arg1	I
    //   1357: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1360: ldc 207
    //   1362: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1365: lload 4
    //   1367: invokevirtual 95	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1370: ldc 209
    //   1372: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1375: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1378: invokestatic 63	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1381: lload 4
    //   1383: lconst_0
    //   1384: lcmp
    //   1385: ifge +462 -> 1847
    //   1388: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1391: ifeq +49 -> 1440
    //   1394: ldc 57
    //   1396: iconst_2
    //   1397: new 79	java/lang/StringBuilder
    //   1400: dup
    //   1401: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1404: ldc 211
    //   1406: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1409: lload 4
    //   1411: invokevirtual 95	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1414: ldc 207
    //   1416: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1419: aload_0
    //   1420: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1423: invokestatic 194	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)J
    //   1426: invokevirtual 95	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1429: ldc 209
    //   1431: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1434: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1437: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1440: aload_0
    //   1441: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1444: getfield 217	com/tencent/mobileqq/activity/Conversation:b	J
    //   1447: lconst_1
    //   1448: ladd
    //   1449: lstore 4
    //   1451: aload_1
    //   1452: getfield 221	android/os/Message:obj	Ljava/lang/Object;
    //   1455: checkcast 223	java/util/List
    //   1458: astore 6
    //   1460: aload_1
    //   1461: getfield 226	android/os/Message:arg2	I
    //   1464: iconst_1
    //   1465: if_icmpeq +85 -> 1550
    //   1468: lload 4
    //   1470: aload_0
    //   1471: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1474: getfield 217	com/tencent/mobileqq/activity/Conversation:b	J
    //   1477: lcmp
    //   1478: ifge +72 -> 1550
    //   1481: aload_0
    //   1482: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1485: aload 6
    //   1487: putfield 229	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1490: invokestatic 173	android/os/Message:obtain	()Landroid/os/Message;
    //   1493: astore_1
    //   1494: aload_1
    //   1495: sipush 10000
    //   1498: putfield 26	android/os/Message:what	I
    //   1501: aload_1
    //   1502: aload_0
    //   1503: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1506: getfield 229	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1509: putfield 221	android/os/Message:obj	Ljava/lang/Object;
    //   1512: aload_1
    //   1513: iconst_0
    //   1514: putfield 138	android/os/Message:arg1	I
    //   1517: aload_1
    //   1518: iconst_1
    //   1519: putfield 226	android/os/Message:arg2	I
    //   1522: aload_0
    //   1523: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1526: getfield 176	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1529: aload_1
    //   1530: aload_0
    //   1531: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1534: getfield 217	com/tencent/mobileqq/activity/Conversation:b	J
    //   1537: lload 4
    //   1539: lsub
    //   1540: ldc2_w 230
    //   1543: ladd
    //   1544: invokevirtual 182	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   1547: pop
    //   1548: iconst_1
    //   1549: ireturn
    //   1550: aload_1
    //   1551: getfield 226	android/os/Message:arg2	I
    //   1554: iconst_1
    //   1555: if_icmpne +54 -> 1609
    //   1558: aload 6
    //   1560: aload_0
    //   1561: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1564: getfield 229	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1567: if_acmpne +37 -> 1604
    //   1570: iconst_1
    //   1571: istore_2
    //   1572: iload_2
    //   1573: ifeq -1525 -> 48
    //   1576: aload_0
    //   1577: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1580: iconst_0
    //   1581: aload_0
    //   1582: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1585: getfield 229	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1588: invokevirtual 234	com/tencent/mobileqq/activity/Conversation:a	(ILjava/util/List;)V
    //   1591: aload_0
    //   1592: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1595: invokestatic 92	java/lang/System:currentTimeMillis	()J
    //   1598: invokestatic 237	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;J)J
    //   1601: pop2
    //   1602: iconst_1
    //   1603: ireturn
    //   1604: iconst_0
    //   1605: istore_2
    //   1606: goto -34 -> 1572
    //   1609: aload_0
    //   1610: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1613: aload 6
    //   1615: putfield 229	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1618: iconst_1
    //   1619: istore_2
    //   1620: goto -48 -> 1572
    //   1623: aload_1
    //   1624: getfield 221	android/os/Message:obj	Ljava/lang/Object;
    //   1627: checkcast 223	java/util/List
    //   1630: astore_1
    //   1631: aload_0
    //   1632: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1635: iconst_1
    //   1636: aload_1
    //   1637: invokevirtual 234	com/tencent/mobileqq/activity/Conversation:a	(ILjava/util/List;)V
    //   1640: iconst_1
    //   1641: ireturn
    //   1642: aload_0
    //   1643: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1646: invokestatic 239	com/tencent/mobileqq/activity/Conversation:b	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   1649: iconst_1
    //   1650: ireturn
    //   1651: aload_0
    //   1652: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1655: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1658: astore 6
    //   1660: iload_3
    //   1661: istore_2
    //   1662: aload_0
    //   1663: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1666: getfield 42	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1669: invokevirtual 242	com/tencent/mobileqq/app/QQAppInterface:a	()Lcooperation/qlink/QQProxyForQlink;
    //   1672: invokevirtual 247	cooperation/qlink/QQProxyForQlink:a	()I
    //   1675: ifeq +5 -> 1680
    //   1678: iconst_2
    //   1679: istore_2
    //   1680: aload 6
    //   1682: bipush 19
    //   1684: iload_2
    //   1685: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1688: aload_0
    //   1689: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1692: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1695: aload_1
    //   1696: invokevirtual 104	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   1699: iconst_1
    //   1700: ireturn
    //   1701: aload_0
    //   1702: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1705: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1708: astore 6
    //   1710: invokestatic 252	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:a	()Lcom/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService;
    //   1713: invokevirtual 253	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:a	()Z
    //   1716: ifeq +24 -> 1740
    //   1719: aload 6
    //   1721: bipush 20
    //   1723: iload_2
    //   1724: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1727: aload_0
    //   1728: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1731: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1734: aload_1
    //   1735: invokevirtual 104	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   1738: iconst_1
    //   1739: ireturn
    //   1740: iconst_0
    //   1741: istore_2
    //   1742: goto -23 -> 1719
    //   1745: getstatic 257	com/tencent/mobileqq/activity/recent/DrawerFrame:f	I
    //   1748: ifle -1700 -> 48
    //   1751: invokestatic 259	com/tencent/mobileqq/activity/Conversation:i	()V
    //   1754: iconst_1
    //   1755: ireturn
    //   1756: aload_0
    //   1757: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1760: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1763: bipush 16
    //   1765: iconst_2
    //   1766: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1769: aload_0
    //   1770: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1773: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1776: aload_1
    //   1777: invokevirtual 104	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   1780: aload_0
    //   1781: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1784: getfield 42	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1787: ldc_w 261
    //   1790: ldc_w 263
    //   1793: ldc_w 263
    //   1796: ldc_w 265
    //   1799: ldc_w 265
    //   1802: iconst_0
    //   1803: iconst_0
    //   1804: ldc_w 263
    //   1807: ldc_w 263
    //   1810: ldc_w 263
    //   1813: ldc_w 263
    //   1816: invokestatic 270	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1819: iconst_1
    //   1820: ireturn
    //   1821: aload_0
    //   1822: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1825: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1828: bipush 16
    //   1830: iconst_0
    //   1831: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1834: aload_0
    //   1835: getfield 12	dsd:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1838: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1841: aload_1
    //   1842: invokevirtual 104	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   1845: iconst_1
    //   1846: ireturn
    //   1847: goto -396 -> 1451
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1850	0	this	dsd
    //   0	1850	1	paramMessage	android.os.Message
    //   1	1741	2	i	int
    //   3	1658	3	j	int
    //   1330	208	4	l	long
    //   696	1	6	localException	java.lang.Exception
    //   1458	262	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   651	661	696	java/lang/Exception
    //   651	661	710	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dsd
 * JD-Core Version:    0.7.0.1
 */