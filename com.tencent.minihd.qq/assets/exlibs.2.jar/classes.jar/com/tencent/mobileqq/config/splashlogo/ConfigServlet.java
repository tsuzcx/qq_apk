package com.tencent.mobileqq.config.splashlogo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBarData;
import com.tencent.mobileqq.activity.recent.LightTalkTipsData;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.Config;
import com.tencent.mobileqq.config.ConfigManager;
import com.tencent.mobileqq.config.NearbyBannerManager;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.mobileqq.config.struct.PicAndAdConf;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.DeviceInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Screen;
import com.tencent.mobileqq.data.ExpiredPushBanner;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qcall.LightalkSwitchManager;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.EnterConfigManager;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import hxq;
import hxr;
import hxs;
import hxt;
import hxu;
import hxv;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.Packet;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ConfigServlet
  extends MSFServlet
{
  public static final int a = 51;
  public static final String a = "ConfigurationService.ReqGetConfig";
  public static final int b = 52;
  public static final String b = "k_cmd_type";
  public static final int c = 6;
  public static final String c = "SPLASH_ConfigServlet";
  public static final int d = 13;
  public static String d = "";
  public static final int e = 18;
  private static String e = "用户";
  public static final int f = 101;
  
  private float a(float paramFloat)
  {
    return paramFloat / (50.0F * 2.0F) * (float)DeviceInfoUtil.f();
  }
  
  private float a(float paramFloat1, float paramFloat2)
  {
    return (50.0F + paramFloat1) / (50.0F * 2.0F) * paramFloat2;
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat2 / 2.0F - paramFloat1 * paramFloat3 / (50.0F * 2.0F);
  }
  
  /* Error */
  private com.tencent.mobileqq.config.operation.QQOperationViopTipTask a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 70	com/tencent/mobileqq/config/operation/QQOperationViopTipTask
    //   5: dup
    //   6: invokespecial 71	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:<init>	()V
    //   9: astore_3
    //   10: invokestatic 77	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   13: invokevirtual 81	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   16: new 83	java/io/ByteArrayInputStream
    //   19: dup
    //   20: aload_1
    //   21: ldc 85
    //   23: invokevirtual 91	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   26: invokespecial 94	java/io/ByteArrayInputStream:<init>	([B)V
    //   29: invokevirtual 100	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   32: astore_1
    //   33: aload_1
    //   34: ldc 102
    //   36: invokeinterface 108 2 0
    //   41: astore 4
    //   43: aload 4
    //   45: ifnull +1204 -> 1249
    //   48: aload 4
    //   50: invokeinterface 114 1 0
    //   55: ifle +1194 -> 1249
    //   58: aload_1
    //   59: ldc 116
    //   61: invokeinterface 108 2 0
    //   66: astore 4
    //   68: aload 4
    //   70: ifnull +44 -> 114
    //   73: aload 4
    //   75: invokeinterface 114 1 0
    //   80: ifle +34 -> 114
    //   83: aload_3
    //   84: aload_1
    //   85: ldc 116
    //   87: invokeinterface 108 2 0
    //   92: iconst_0
    //   93: invokeinterface 120 2 0
    //   98: invokeinterface 126 1 0
    //   103: invokeinterface 130 1 0
    //   108: invokestatic 136	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   111: putfield 139	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:taskid	I
    //   114: aload_1
    //   115: ldc 141
    //   117: invokeinterface 108 2 0
    //   122: astore 4
    //   124: aload 4
    //   126: ifnull +44 -> 170
    //   129: aload 4
    //   131: invokeinterface 114 1 0
    //   136: ifle +34 -> 170
    //   139: aload_3
    //   140: aload_1
    //   141: ldc 141
    //   143: invokeinterface 108 2 0
    //   148: iconst_0
    //   149: invokeinterface 120 2 0
    //   154: invokeinterface 126 1 0
    //   159: invokeinterface 130 1 0
    //   164: invokestatic 136	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   167: putfield 144	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:limitDayAIOCount	I
    //   170: aload_1
    //   171: ldc 146
    //   173: invokeinterface 108 2 0
    //   178: astore 4
    //   180: aload 4
    //   182: ifnull +44 -> 226
    //   185: aload 4
    //   187: invokeinterface 114 1 0
    //   192: ifle +34 -> 226
    //   195: aload_3
    //   196: aload_1
    //   197: ldc 146
    //   199: invokeinterface 108 2 0
    //   204: iconst_0
    //   205: invokeinterface 120 2 0
    //   210: invokeinterface 126 1 0
    //   215: invokeinterface 130 1 0
    //   220: invokestatic 136	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   223: putfield 149	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:limitDayAIOShowCount	I
    //   226: aload_1
    //   227: ldc 151
    //   229: invokeinterface 108 2 0
    //   234: astore 4
    //   236: aload 4
    //   238: ifnull +44 -> 282
    //   241: aload 4
    //   243: invokeinterface 114 1 0
    //   248: ifle +34 -> 282
    //   251: aload_3
    //   252: aload_1
    //   253: ldc 151
    //   255: invokeinterface 108 2 0
    //   260: iconst_0
    //   261: invokeinterface 120 2 0
    //   266: invokeinterface 126 1 0
    //   271: invokeinterface 130 1 0
    //   276: invokestatic 136	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   279: putfield 154	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:limitTotalAIOCount	I
    //   282: aload_1
    //   283: ldc 156
    //   285: invokeinterface 108 2 0
    //   290: astore 4
    //   292: aload 4
    //   294: ifnull +44 -> 338
    //   297: aload 4
    //   299: invokeinterface 114 1 0
    //   304: ifle +34 -> 338
    //   307: aload_3
    //   308: aload_1
    //   309: ldc 156
    //   311: invokeinterface 108 2 0
    //   316: iconst_0
    //   317: invokeinterface 120 2 0
    //   322: invokeinterface 126 1 0
    //   327: invokeinterface 130 1 0
    //   332: invokestatic 136	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   335: putfield 159	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:limitTotalShowCount	I
    //   338: aload_1
    //   339: ldc 161
    //   341: invokeinterface 108 2 0
    //   346: astore 4
    //   348: aload 4
    //   350: ifnull +41 -> 391
    //   353: aload 4
    //   355: invokeinterface 114 1 0
    //   360: ifle +31 -> 391
    //   363: aload_3
    //   364: aload_1
    //   365: ldc 161
    //   367: invokeinterface 108 2 0
    //   372: iconst_0
    //   373: invokeinterface 120 2 0
    //   378: invokeinterface 126 1 0
    //   383: invokeinterface 130 1 0
    //   388: invokevirtual 165	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:setKeywordString	(Ljava/lang/String;)V
    //   391: invokestatic 171	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   394: ifeq +31 -> 425
    //   397: ldc 173
    //   399: iconst_4
    //   400: new 175	java/lang/StringBuilder
    //   403: dup
    //   404: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   407: ldc 178
    //   409: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: aload_3
    //   413: invokevirtual 186	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:getKeywordList	()Ljava/util/ArrayList;
    //   416: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 195	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   425: aload_1
    //   426: ldc 197
    //   428: invokeinterface 108 2 0
    //   433: astore 4
    //   435: aload 4
    //   437: ifnull +41 -> 478
    //   440: aload 4
    //   442: invokeinterface 114 1 0
    //   447: ifle +31 -> 478
    //   450: aload_3
    //   451: aload_1
    //   452: ldc 197
    //   454: invokeinterface 108 2 0
    //   459: iconst_0
    //   460: invokeinterface 120 2 0
    //   465: invokeinterface 126 1 0
    //   470: invokeinterface 130 1 0
    //   475: invokevirtual 200	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:setBeginTime	(Ljava/lang/String;)V
    //   478: aload_1
    //   479: ldc 202
    //   481: invokeinterface 108 2 0
    //   486: astore 4
    //   488: aload 4
    //   490: ifnull +41 -> 531
    //   493: aload 4
    //   495: invokeinterface 114 1 0
    //   500: ifle +31 -> 531
    //   503: aload_3
    //   504: aload_1
    //   505: ldc 202
    //   507: invokeinterface 108 2 0
    //   512: iconst_0
    //   513: invokeinterface 120 2 0
    //   518: invokeinterface 126 1 0
    //   523: invokeinterface 130 1 0
    //   528: invokevirtual 205	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:setEndTime	(Ljava/lang/String;)V
    //   531: aload_1
    //   532: ldc 207
    //   534: invokeinterface 108 2 0
    //   539: astore 4
    //   541: aload 4
    //   543: ifnull +49 -> 592
    //   546: aload 4
    //   548: invokeinterface 114 1 0
    //   553: ifle +39 -> 592
    //   556: aload_1
    //   557: ldc 207
    //   559: invokeinterface 108 2 0
    //   564: iconst_0
    //   565: invokeinterface 120 2 0
    //   570: invokeinterface 126 1 0
    //   575: invokeinterface 130 1 0
    //   580: invokestatic 136	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   583: iconst_1
    //   584: if_icmpne +667 -> 1251
    //   587: aload_3
    //   588: iload_2
    //   589: putfield 210	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:uinType	I
    //   592: aload_1
    //   593: ldc 212
    //   595: invokeinterface 108 2 0
    //   600: astore 4
    //   602: aload 4
    //   604: ifnull +189 -> 793
    //   607: aload 4
    //   609: invokeinterface 114 1 0
    //   614: ifle +179 -> 793
    //   617: aload_1
    //   618: ldc 212
    //   620: invokeinterface 108 2 0
    //   625: iconst_0
    //   626: invokeinterface 120 2 0
    //   631: checkcast 214	org/w3c/dom/Element
    //   634: ldc 216
    //   636: invokeinterface 217 2 0
    //   641: astore 4
    //   643: aload 4
    //   645: ifnull +60 -> 705
    //   648: aload 4
    //   650: invokeinterface 114 1 0
    //   655: ifle +50 -> 705
    //   658: aload_3
    //   659: aload_1
    //   660: ldc 212
    //   662: invokeinterface 108 2 0
    //   667: iconst_0
    //   668: invokeinterface 120 2 0
    //   673: checkcast 214	org/w3c/dom/Element
    //   676: ldc 216
    //   678: invokeinterface 217 2 0
    //   683: iconst_0
    //   684: invokeinterface 120 2 0
    //   689: invokeinterface 126 1 0
    //   694: invokeinterface 130 1 0
    //   699: invokestatic 136	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   702: putfield 220	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:frequencyTime	I
    //   705: aload_1
    //   706: ldc 212
    //   708: invokeinterface 108 2 0
    //   713: iconst_0
    //   714: invokeinterface 120 2 0
    //   719: checkcast 214	org/w3c/dom/Element
    //   722: ldc 222
    //   724: invokeinterface 217 2 0
    //   729: astore 4
    //   731: aload 4
    //   733: ifnull +60 -> 793
    //   736: aload 4
    //   738: invokeinterface 114 1 0
    //   743: ifle +50 -> 793
    //   746: aload_3
    //   747: aload_1
    //   748: ldc 212
    //   750: invokeinterface 108 2 0
    //   755: iconst_0
    //   756: invokeinterface 120 2 0
    //   761: checkcast 214	org/w3c/dom/Element
    //   764: ldc 222
    //   766: invokeinterface 217 2 0
    //   771: iconst_0
    //   772: invokeinterface 120 2 0
    //   777: invokeinterface 126 1 0
    //   782: invokeinterface 130 1 0
    //   787: invokestatic 136	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   790: putfield 225	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:frequencyMessage	I
    //   793: aload_1
    //   794: ldc 227
    //   796: invokeinterface 108 2 0
    //   801: astore 4
    //   803: aload 4
    //   805: ifnull +444 -> 1249
    //   808: aload 4
    //   810: invokeinterface 114 1 0
    //   815: ifle +434 -> 1249
    //   818: aload_1
    //   819: ldc 227
    //   821: invokeinterface 108 2 0
    //   826: iconst_0
    //   827: invokeinterface 120 2 0
    //   832: checkcast 214	org/w3c/dom/Element
    //   835: ldc 229
    //   837: invokeinterface 217 2 0
    //   842: astore 4
    //   844: aload 4
    //   846: ifnull +60 -> 906
    //   849: aload 4
    //   851: invokeinterface 114 1 0
    //   856: ifle +50 -> 906
    //   859: aload_3
    //   860: aload_1
    //   861: ldc 227
    //   863: invokeinterface 108 2 0
    //   868: iconst_0
    //   869: invokeinterface 120 2 0
    //   874: checkcast 214	org/w3c/dom/Element
    //   877: ldc 229
    //   879: invokeinterface 217 2 0
    //   884: iconst_0
    //   885: invokeinterface 120 2 0
    //   890: invokeinterface 126 1 0
    //   895: invokeinterface 130 1 0
    //   900: invokestatic 136	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   903: putfield 232	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:tipType	I
    //   906: aload_1
    //   907: ldc 227
    //   909: invokeinterface 108 2 0
    //   914: iconst_0
    //   915: invokeinterface 120 2 0
    //   920: checkcast 214	org/w3c/dom/Element
    //   923: ldc 222
    //   925: invokeinterface 217 2 0
    //   930: astore 4
    //   932: aload 4
    //   934: ifnull +57 -> 991
    //   937: aload 4
    //   939: invokeinterface 114 1 0
    //   944: ifle +47 -> 991
    //   947: aload_3
    //   948: aload_1
    //   949: ldc 227
    //   951: invokeinterface 108 2 0
    //   956: iconst_0
    //   957: invokeinterface 120 2 0
    //   962: checkcast 214	org/w3c/dom/Element
    //   965: ldc 222
    //   967: invokeinterface 217 2 0
    //   972: iconst_0
    //   973: invokeinterface 120 2 0
    //   978: invokeinterface 126 1 0
    //   983: invokeinterface 130 1 0
    //   988: putfield 235	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:adwords	Ljava/lang/String;
    //   991: aload_1
    //   992: ldc 227
    //   994: invokeinterface 108 2 0
    //   999: iconst_0
    //   1000: invokeinterface 120 2 0
    //   1005: checkcast 214	org/w3c/dom/Element
    //   1008: ldc 237
    //   1010: invokeinterface 217 2 0
    //   1015: astore 4
    //   1017: aload 4
    //   1019: ifnull +60 -> 1079
    //   1022: aload 4
    //   1024: invokeinterface 114 1 0
    //   1029: ifle +50 -> 1079
    //   1032: aload_3
    //   1033: aload_1
    //   1034: ldc 227
    //   1036: invokeinterface 108 2 0
    //   1041: iconst_0
    //   1042: invokeinterface 120 2 0
    //   1047: checkcast 214	org/w3c/dom/Element
    //   1050: ldc 237
    //   1052: invokeinterface 217 2 0
    //   1057: iconst_0
    //   1058: invokeinterface 120 2 0
    //   1063: invokeinterface 126 1 0
    //   1068: invokeinterface 130 1 0
    //   1073: invokestatic 136	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1076: putfield 240	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:linkOffset	I
    //   1079: aload_1
    //   1080: ldc 227
    //   1082: invokeinterface 108 2 0
    //   1087: iconst_0
    //   1088: invokeinterface 120 2 0
    //   1093: checkcast 214	org/w3c/dom/Element
    //   1096: ldc 242
    //   1098: invokeinterface 217 2 0
    //   1103: astore 4
    //   1105: aload 4
    //   1107: ifnull +57 -> 1164
    //   1110: aload 4
    //   1112: invokeinterface 114 1 0
    //   1117: ifle +47 -> 1164
    //   1120: aload_3
    //   1121: aload_1
    //   1122: ldc 227
    //   1124: invokeinterface 108 2 0
    //   1129: iconst_0
    //   1130: invokeinterface 120 2 0
    //   1135: checkcast 214	org/w3c/dom/Element
    //   1138: ldc 242
    //   1140: invokeinterface 217 2 0
    //   1145: iconst_0
    //   1146: invokeinterface 120 2 0
    //   1151: invokeinterface 126 1 0
    //   1156: invokeinterface 130 1 0
    //   1161: putfield 245	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:clickableWord	Ljava/lang/String;
    //   1164: aload_1
    //   1165: ldc 227
    //   1167: invokeinterface 108 2 0
    //   1172: iconst_0
    //   1173: invokeinterface 120 2 0
    //   1178: checkcast 214	org/w3c/dom/Element
    //   1181: ldc 247
    //   1183: invokeinterface 217 2 0
    //   1188: astore 4
    //   1190: aload 4
    //   1192: ifnull +57 -> 1249
    //   1195: aload 4
    //   1197: invokeinterface 114 1 0
    //   1202: ifle +47 -> 1249
    //   1205: aload_3
    //   1206: aload_1
    //   1207: ldc 227
    //   1209: invokeinterface 108 2 0
    //   1214: iconst_0
    //   1215: invokeinterface 120 2 0
    //   1220: checkcast 214	org/w3c/dom/Element
    //   1223: ldc 247
    //   1225: invokeinterface 217 2 0
    //   1230: iconst_0
    //   1231: invokeinterface 120 2 0
    //   1236: invokeinterface 126 1 0
    //   1241: invokeinterface 130 1 0
    //   1246: putfield 249	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:url	Ljava/lang/String;
    //   1249: aload_3
    //   1250: areturn
    //   1251: sipush 3000
    //   1254: istore_2
    //   1255: goto -668 -> 587
    //   1258: astore_1
    //   1259: aload_1
    //   1260: invokevirtual 252	javax/xml/parsers/ParserConfigurationException:printStackTrace	()V
    //   1263: aconst_null
    //   1264: areturn
    //   1265: astore_1
    //   1266: aload_1
    //   1267: invokevirtual 253	org/xml/sax/SAXException:printStackTrace	()V
    //   1270: goto -7 -> 1263
    //   1273: astore_1
    //   1274: aload_1
    //   1275: invokevirtual 254	java/io/IOException:printStackTrace	()V
    //   1278: goto -15 -> 1263
    //   1281: astore_1
    //   1282: aload_1
    //   1283: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   1286: goto -23 -> 1263
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1289	0	this	ConfigServlet
    //   0	1289	1	paramString	String
    //   1	1254	2	i	int
    //   9	1241	3	localQQOperationViopTipTask	com.tencent.mobileqq.config.operation.QQOperationViopTipTask
    //   41	1155	4	localNodeList	NodeList
    // Exception table:
    //   from	to	target	type
    //   2	43	1258	javax/xml/parsers/ParserConfigurationException
    //   48	68	1258	javax/xml/parsers/ParserConfigurationException
    //   73	114	1258	javax/xml/parsers/ParserConfigurationException
    //   114	124	1258	javax/xml/parsers/ParserConfigurationException
    //   129	170	1258	javax/xml/parsers/ParserConfigurationException
    //   170	180	1258	javax/xml/parsers/ParserConfigurationException
    //   185	226	1258	javax/xml/parsers/ParserConfigurationException
    //   226	236	1258	javax/xml/parsers/ParserConfigurationException
    //   241	282	1258	javax/xml/parsers/ParserConfigurationException
    //   282	292	1258	javax/xml/parsers/ParserConfigurationException
    //   297	338	1258	javax/xml/parsers/ParserConfigurationException
    //   338	348	1258	javax/xml/parsers/ParserConfigurationException
    //   353	391	1258	javax/xml/parsers/ParserConfigurationException
    //   391	425	1258	javax/xml/parsers/ParserConfigurationException
    //   425	435	1258	javax/xml/parsers/ParserConfigurationException
    //   440	478	1258	javax/xml/parsers/ParserConfigurationException
    //   478	488	1258	javax/xml/parsers/ParserConfigurationException
    //   493	531	1258	javax/xml/parsers/ParserConfigurationException
    //   531	541	1258	javax/xml/parsers/ParserConfigurationException
    //   546	587	1258	javax/xml/parsers/ParserConfigurationException
    //   587	592	1258	javax/xml/parsers/ParserConfigurationException
    //   592	602	1258	javax/xml/parsers/ParserConfigurationException
    //   607	643	1258	javax/xml/parsers/ParserConfigurationException
    //   648	705	1258	javax/xml/parsers/ParserConfigurationException
    //   705	731	1258	javax/xml/parsers/ParserConfigurationException
    //   736	793	1258	javax/xml/parsers/ParserConfigurationException
    //   793	803	1258	javax/xml/parsers/ParserConfigurationException
    //   808	844	1258	javax/xml/parsers/ParserConfigurationException
    //   849	906	1258	javax/xml/parsers/ParserConfigurationException
    //   906	932	1258	javax/xml/parsers/ParserConfigurationException
    //   937	991	1258	javax/xml/parsers/ParserConfigurationException
    //   991	1017	1258	javax/xml/parsers/ParserConfigurationException
    //   1022	1079	1258	javax/xml/parsers/ParserConfigurationException
    //   1079	1105	1258	javax/xml/parsers/ParserConfigurationException
    //   1110	1164	1258	javax/xml/parsers/ParserConfigurationException
    //   1164	1190	1258	javax/xml/parsers/ParserConfigurationException
    //   1195	1249	1258	javax/xml/parsers/ParserConfigurationException
    //   2	43	1265	org/xml/sax/SAXException
    //   48	68	1265	org/xml/sax/SAXException
    //   73	114	1265	org/xml/sax/SAXException
    //   114	124	1265	org/xml/sax/SAXException
    //   129	170	1265	org/xml/sax/SAXException
    //   170	180	1265	org/xml/sax/SAXException
    //   185	226	1265	org/xml/sax/SAXException
    //   226	236	1265	org/xml/sax/SAXException
    //   241	282	1265	org/xml/sax/SAXException
    //   282	292	1265	org/xml/sax/SAXException
    //   297	338	1265	org/xml/sax/SAXException
    //   338	348	1265	org/xml/sax/SAXException
    //   353	391	1265	org/xml/sax/SAXException
    //   391	425	1265	org/xml/sax/SAXException
    //   425	435	1265	org/xml/sax/SAXException
    //   440	478	1265	org/xml/sax/SAXException
    //   478	488	1265	org/xml/sax/SAXException
    //   493	531	1265	org/xml/sax/SAXException
    //   531	541	1265	org/xml/sax/SAXException
    //   546	587	1265	org/xml/sax/SAXException
    //   587	592	1265	org/xml/sax/SAXException
    //   592	602	1265	org/xml/sax/SAXException
    //   607	643	1265	org/xml/sax/SAXException
    //   648	705	1265	org/xml/sax/SAXException
    //   705	731	1265	org/xml/sax/SAXException
    //   736	793	1265	org/xml/sax/SAXException
    //   793	803	1265	org/xml/sax/SAXException
    //   808	844	1265	org/xml/sax/SAXException
    //   849	906	1265	org/xml/sax/SAXException
    //   906	932	1265	org/xml/sax/SAXException
    //   937	991	1265	org/xml/sax/SAXException
    //   991	1017	1265	org/xml/sax/SAXException
    //   1022	1079	1265	org/xml/sax/SAXException
    //   1079	1105	1265	org/xml/sax/SAXException
    //   1110	1164	1265	org/xml/sax/SAXException
    //   1164	1190	1265	org/xml/sax/SAXException
    //   1195	1249	1265	org/xml/sax/SAXException
    //   2	43	1273	java/io/IOException
    //   48	68	1273	java/io/IOException
    //   73	114	1273	java/io/IOException
    //   114	124	1273	java/io/IOException
    //   129	170	1273	java/io/IOException
    //   170	180	1273	java/io/IOException
    //   185	226	1273	java/io/IOException
    //   226	236	1273	java/io/IOException
    //   241	282	1273	java/io/IOException
    //   282	292	1273	java/io/IOException
    //   297	338	1273	java/io/IOException
    //   338	348	1273	java/io/IOException
    //   353	391	1273	java/io/IOException
    //   391	425	1273	java/io/IOException
    //   425	435	1273	java/io/IOException
    //   440	478	1273	java/io/IOException
    //   478	488	1273	java/io/IOException
    //   493	531	1273	java/io/IOException
    //   531	541	1273	java/io/IOException
    //   546	587	1273	java/io/IOException
    //   587	592	1273	java/io/IOException
    //   592	602	1273	java/io/IOException
    //   607	643	1273	java/io/IOException
    //   648	705	1273	java/io/IOException
    //   705	731	1273	java/io/IOException
    //   736	793	1273	java/io/IOException
    //   793	803	1273	java/io/IOException
    //   808	844	1273	java/io/IOException
    //   849	906	1273	java/io/IOException
    //   906	932	1273	java/io/IOException
    //   937	991	1273	java/io/IOException
    //   991	1017	1273	java/io/IOException
    //   1022	1079	1273	java/io/IOException
    //   1079	1105	1273	java/io/IOException
    //   1110	1164	1273	java/io/IOException
    //   1164	1190	1273	java/io/IOException
    //   1195	1249	1273	java/io/IOException
    //   2	43	1281	java/lang/Exception
    //   48	68	1281	java/lang/Exception
    //   73	114	1281	java/lang/Exception
    //   114	124	1281	java/lang/Exception
    //   129	170	1281	java/lang/Exception
    //   170	180	1281	java/lang/Exception
    //   185	226	1281	java/lang/Exception
    //   226	236	1281	java/lang/Exception
    //   241	282	1281	java/lang/Exception
    //   282	292	1281	java/lang/Exception
    //   297	338	1281	java/lang/Exception
    //   338	348	1281	java/lang/Exception
    //   353	391	1281	java/lang/Exception
    //   391	425	1281	java/lang/Exception
    //   425	435	1281	java/lang/Exception
    //   440	478	1281	java/lang/Exception
    //   478	488	1281	java/lang/Exception
    //   493	531	1281	java/lang/Exception
    //   531	541	1281	java/lang/Exception
    //   546	587	1281	java/lang/Exception
    //   587	592	1281	java/lang/Exception
    //   592	602	1281	java/lang/Exception
    //   607	643	1281	java/lang/Exception
    //   648	705	1281	java/lang/Exception
    //   705	731	1281	java/lang/Exception
    //   736	793	1281	java/lang/Exception
    //   793	803	1281	java/lang/Exception
    //   808	844	1281	java/lang/Exception
    //   849	906	1281	java/lang/Exception
    //   906	932	1281	java/lang/Exception
    //   937	991	1281	java/lang/Exception
    //   991	1017	1281	java/lang/Exception
    //   1022	1079	1281	java/lang/Exception
    //   1079	1105	1281	java/lang/Exception
    //   1110	1164	1281	java/lang/Exception
    //   1164	1190	1281	java/lang/Exception
    //   1195	1249	1281	java/lang/Exception
  }
  
  /* Error */
  public static String a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 260	java/io/File
    //   5: dup
    //   6: new 175	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   13: invokestatic 266	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   16: invokevirtual 269	java/io/File:getPath	()Ljava/lang/String;
    //   19: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc_w 271
    //   25: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: iload_0
    //   29: invokevirtual 274	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: ldc_w 276
    //   35: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokespecial 278	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: astore 6
    //   46: aload 6
    //   48: invokevirtual 281	java/io/File:exists	()Z
    //   51: ifeq +101 -> 152
    //   54: new 283	java/io/FileInputStream
    //   57: dup
    //   58: aload 6
    //   60: invokespecial 286	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   63: astore_1
    //   64: new 288	java/io/ByteArrayOutputStream
    //   67: dup
    //   68: invokespecial 289	java/io/ByteArrayOutputStream:<init>	()V
    //   71: astore_3
    //   72: aload_3
    //   73: astore 5
    //   75: aload_1
    //   76: astore 4
    //   78: aload 6
    //   80: invokevirtual 292	java/io/File:length	()J
    //   83: l2i
    //   84: newarray byte
    //   86: astore_2
    //   87: aload_3
    //   88: astore 5
    //   90: aload_1
    //   91: astore 4
    //   93: aload_1
    //   94: aload_2
    //   95: iconst_0
    //   96: aload_2
    //   97: arraylength
    //   98: invokevirtual 296	java/io/FileInputStream:read	([BII)I
    //   101: istore_0
    //   102: iload_0
    //   103: iconst_m1
    //   104: if_icmpeq +53 -> 157
    //   107: aload_3
    //   108: astore 5
    //   110: aload_1
    //   111: astore 4
    //   113: aload_3
    //   114: aload_2
    //   115: iconst_0
    //   116: iload_0
    //   117: invokevirtual 300	java/io/ByteArrayOutputStream:write	([BII)V
    //   120: goto -33 -> 87
    //   123: astore 4
    //   125: aload_1
    //   126: astore_2
    //   127: aload_3
    //   128: astore_1
    //   129: aload 4
    //   131: astore_3
    //   132: aload_3
    //   133: invokevirtual 301	java/io/FileNotFoundException:printStackTrace	()V
    //   136: aload_2
    //   137: ifnull +7 -> 144
    //   140: aload_2
    //   141: invokevirtual 304	java/io/FileInputStream:close	()V
    //   144: aload_1
    //   145: ifnull +7 -> 152
    //   148: aload_1
    //   149: invokevirtual 305	java/io/ByteArrayOutputStream:close	()V
    //   152: ldc 28
    //   154: astore_1
    //   155: aload_1
    //   156: areturn
    //   157: aload_3
    //   158: astore 5
    //   160: aload_1
    //   161: astore 4
    //   163: new 87	java/lang/String
    //   166: dup
    //   167: aload_3
    //   168: invokevirtual 309	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   171: ldc 85
    //   173: invokespecial 312	java/lang/String:<init>	([BLjava/lang/String;)V
    //   176: astore_2
    //   177: aload_1
    //   178: ifnull +7 -> 185
    //   181: aload_1
    //   182: invokevirtual 304	java/io/FileInputStream:close	()V
    //   185: aload_2
    //   186: astore_1
    //   187: aload_3
    //   188: ifnull -33 -> 155
    //   191: aload_3
    //   192: invokevirtual 305	java/io/ByteArrayOutputStream:close	()V
    //   195: aload_2
    //   196: areturn
    //   197: astore_1
    //   198: aload_1
    //   199: invokevirtual 254	java/io/IOException:printStackTrace	()V
    //   202: aload_2
    //   203: areturn
    //   204: astore_1
    //   205: aload_1
    //   206: invokevirtual 254	java/io/IOException:printStackTrace	()V
    //   209: goto -57 -> 152
    //   212: astore 6
    //   214: aconst_null
    //   215: astore_2
    //   216: aconst_null
    //   217: astore_1
    //   218: aload_2
    //   219: astore 5
    //   221: aload_1
    //   222: astore 4
    //   224: aload 6
    //   226: invokevirtual 254	java/io/IOException:printStackTrace	()V
    //   229: aload_1
    //   230: ifnull +7 -> 237
    //   233: aload_1
    //   234: invokevirtual 304	java/io/FileInputStream:close	()V
    //   237: aload_2
    //   238: ifnull -86 -> 152
    //   241: aload_2
    //   242: invokevirtual 305	java/io/ByteArrayOutputStream:close	()V
    //   245: goto -93 -> 152
    //   248: astore_1
    //   249: aload_1
    //   250: invokevirtual 254	java/io/IOException:printStackTrace	()V
    //   253: goto -101 -> 152
    //   256: astore_2
    //   257: aconst_null
    //   258: astore_3
    //   259: aconst_null
    //   260: astore_1
    //   261: aload_1
    //   262: ifnull +7 -> 269
    //   265: aload_1
    //   266: invokevirtual 304	java/io/FileInputStream:close	()V
    //   269: aload_3
    //   270: ifnull +7 -> 277
    //   273: aload_3
    //   274: invokevirtual 305	java/io/ByteArrayOutputStream:close	()V
    //   277: aload_2
    //   278: athrow
    //   279: astore_1
    //   280: aload_1
    //   281: invokevirtual 254	java/io/IOException:printStackTrace	()V
    //   284: goto -7 -> 277
    //   287: astore_2
    //   288: aconst_null
    //   289: astore_3
    //   290: goto -29 -> 261
    //   293: astore_2
    //   294: aload 5
    //   296: astore_3
    //   297: aload 4
    //   299: astore_1
    //   300: goto -39 -> 261
    //   303: astore_3
    //   304: aload_2
    //   305: astore 4
    //   307: aload_3
    //   308: astore_2
    //   309: aload_1
    //   310: astore_3
    //   311: aload 4
    //   313: astore_1
    //   314: goto -53 -> 261
    //   317: astore 6
    //   319: aconst_null
    //   320: astore_2
    //   321: goto -103 -> 218
    //   324: astore 6
    //   326: aload_3
    //   327: astore_2
    //   328: goto -110 -> 218
    //   331: astore_3
    //   332: aconst_null
    //   333: astore_1
    //   334: goto -202 -> 132
    //   337: astore_3
    //   338: aconst_null
    //   339: astore 4
    //   341: aload_1
    //   342: astore_2
    //   343: aload 4
    //   345: astore_1
    //   346: goto -214 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	paramInt	int
    //   63	124	1	localObject1	Object
    //   197	2	1	localIOException1	java.io.IOException
    //   204	2	1	localIOException2	java.io.IOException
    //   217	17	1	localObject2	Object
    //   248	2	1	localIOException3	java.io.IOException
    //   260	6	1	localObject3	Object
    //   279	2	1	localIOException4	java.io.IOException
    //   299	47	1	localObject4	Object
    //   1	241	2	localObject5	Object
    //   256	22	2	localObject6	Object
    //   287	1	2	localObject7	Object
    //   293	12	2	localObject8	Object
    //   308	35	2	localObject9	Object
    //   71	226	3	localObject10	Object
    //   303	5	3	localObject11	Object
    //   310	17	3	localObject12	Object
    //   331	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   337	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   76	36	4	localObject13	Object
    //   123	7	4	localFileNotFoundException3	java.io.FileNotFoundException
    //   161	183	4	localObject14	Object
    //   73	222	5	localObject15	Object
    //   44	35	6	localFile	File
    //   212	13	6	localIOException5	java.io.IOException
    //   317	1	6	localIOException6	java.io.IOException
    //   324	1	6	localIOException7	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   78	87	123	java/io/FileNotFoundException
    //   93	102	123	java/io/FileNotFoundException
    //   113	120	123	java/io/FileNotFoundException
    //   163	177	123	java/io/FileNotFoundException
    //   181	185	197	java/io/IOException
    //   191	195	197	java/io/IOException
    //   140	144	204	java/io/IOException
    //   148	152	204	java/io/IOException
    //   54	64	212	java/io/IOException
    //   233	237	248	java/io/IOException
    //   241	245	248	java/io/IOException
    //   54	64	256	finally
    //   265	269	279	java/io/IOException
    //   273	277	279	java/io/IOException
    //   64	72	287	finally
    //   78	87	293	finally
    //   93	102	293	finally
    //   113	120	293	finally
    //   163	177	293	finally
    //   224	229	293	finally
    //   132	136	303	finally
    //   64	72	317	java/io/IOException
    //   78	87	324	java/io/IOException
    //   93	102	324	java/io/IOException
    //   113	120	324	java/io/IOException
    //   163	177	324	java/io/IOException
    //   54	64	331	java/io/FileNotFoundException
    //   64	72	337	java/io/FileNotFoundException
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1).append('-').append(paramInt2);
    return localStringBuilder.toString();
  }
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int j = 1;
    boolean bool = paramFromServiceMsg.isSuccess();
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "received GENERAL_CONFIGS_CMD info response: " + bool);
    }
    if (bool)
    {
      paramIntent = paramFromServiceMsg.getWupBuffer();
      if ((paramIntent != null) && (paramIntent.length > 4))
      {
        paramIntent = a(paramFromServiceMsg);
        paramFromServiceMsg = new ConfigurationService.RespGetConfig();
      }
    }
    for (;;)
    {
      Object localObject1;
      int i;
      try
      {
        paramFromServiceMsg.mergeFrom(paramIntent);
        if (paramFromServiceMsg.result.get() == 0)
        {
          if ((paramFromServiceMsg.config_list == null) || (paramFromServiceMsg.config_list.size() <= 0)) {
            break label669;
          }
          paramIntent = (ConfigurationService.Config)paramFromServiceMsg.config_list.get(0);
          if ((paramIntent != null) && (paramIntent.type != null) && (paramIntent.type.get() == 101))
          {
            if ((paramIntent.content_list == null) || (paramIntent.content_list.size() <= 0)) {
              break label664;
            }
            paramFromServiceMsg = paramIntent.content_list.get();
            if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
            {
              localObject1 = new HashMap();
              i = 0;
              if (i >= paramFromServiceMsg.size()) {
                break label366;
              }
              localObject2 = (String)paramFromServiceMsg.get(i);
              if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                break label279;
              }
              i += 1;
              continue;
            }
          }
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramIntent)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "error: " + paramIntent.toString());
        }
        paramIntent.printStackTrace();
      }
      label279:
      Object localObject2 = ((String)localObject2).split("=");
      if ((localObject2 != null) && (localObject2.length == 2))
      {
        ((HashMap)localObject1).put(localObject2[0], localObject2[1]);
        if (QLog.isColorLevel())
        {
          QLog.i("SPLASH_ConfigServlet", 2, "GENERAL_CONFIGS_CMD, name=" + localObject2[0] + ", val=" + localObject2[1]);
          continue;
          label366:
          paramFromServiceMsg = (String)((HashMap)localObject1).get("mask_lightalk");
          localObject2 = (LightalkSwitchManager)localQQAppInterface.getManager(81);
          if (!"1".equals(paramFromServiceMsg))
          {
            bool = true;
            ((LightalkSwitchManager)localObject2).a(bool);
            paramFromServiceMsg = (String)((HashMap)localObject1).get("ptlogin_flag");
            BaseApplication.getContext().getSharedPreferences("mobileQQ", 4).edit().putBoolean("ptlogin_flag" + getAppRuntime().getAccount(), "1".equalsIgnoreCase(paramFromServiceMsg)).commit();
            paramFromServiceMsg = (String)((HashMap)localObject1).get("mqq_calltab");
            localObject1 = (String)((HashMap)localObject1).get("mqq_calltab_setting");
            if ((paramFromServiceMsg != null) || (localObject1 != null))
            {
              localObject2 = new Integer[7];
              if (paramFromServiceMsg != null)
              {
                if (paramFromServiceMsg.indexOf('|') <= 0) {
                  break label631;
                }
                if (!paramFromServiceMsg.split("|")[0].equals("1")) {
                  break label626;
                }
                i = 1;
                label555:
                localObject2[1] = Integer.valueOf(i);
              }
              if (localObject1 != null) {
                if (!((String)localObject1).equals("1")) {
                  break label659;
                }
              }
            }
          }
          label659:
          for (i = j;; i = 0)
          {
            localObject2[5] = Integer.valueOf(i);
            localQQAppInterface.a((Integer[])localObject2);
            i = paramIntent.version.get();
            SharedPreUtils.c(getAppRuntime().getApplication(), i, d);
            return;
            bool = false;
            break;
            label626:
            i = 0;
            break label555;
            label631:
            if (paramFromServiceMsg.equals("1")) {}
            for (i = 1;; i = 0)
            {
              localObject2[1] = Integer.valueOf(i);
              break;
            }
          }
          label664:
          paramFromServiceMsg = null;
          continue;
          label669:
          paramIntent = null;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, 5);
    if (QLog.isDevelopLevel()) {
      QLog.d("QQOperateVoIP", 4, "onSend configXml request");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.a(), ConfigServlet.class);
    localNewIntent.putExtra("k_cmd_type", paramInt);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    d = paramString;
    a(paramQQAppInterface, 13);
    EnterConfigManager.a(BaseApplication.getContext(), paramString).a();
  }
  
  private void a(PicAndAdConf paramPicAndAdConf, String paramString, Set paramSet)
  {
    for (;;)
    {
      Document localDocument;
      int i;
      long l1;
      String str1;
      String str2;
      int k;
      Object localObject;
      long l2;
      long l3;
      try
      {
        localDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
        NodeList localNodeList = localDocument.getElementsByTagName("pushbanner");
        paramString = "";
        i = 0;
        if (i < localNodeList.getLength())
        {
          l1 = Long.parseLong(localDocument.getElementsByTagName("channel").item(i).getFirstChild().getNodeValue());
          str1 = localDocument.getElementsByTagName("img").item(i).getFirstChild().getNodeValue();
          str2 = localDocument.getElementsByTagName("digest").item(i).getFirstChild().getNodeValue();
          k = Integer.parseInt(localDocument.getElementsByTagName("weight").item(i).getFirstChild().getNodeValue());
          localObject = localDocument.getElementsByTagName("md5").item(i).getFirstChild();
          if (localObject != null) {
            paramString = ((Node)localObject).getNodeValue();
          }
          localObject = localDocument.getElementsByTagName("end").item(i).getFirstChild().getNodeValue();
          SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          l2 = localSimpleDateFormat.parse((String)localObject).getTime();
          l3 = localSimpleDateFormat.parse(localDocument.getElementsByTagName("begin").item(i).getFirstChild().getNodeValue()).getTime();
          if (System.currentTimeMillis() > l2)
          {
            if (QLog.isColorLevel()) {
              QLog.i("SPLASH_ConfigServlet", 2, "parseXML | NearbyBanner out of date, cid = " + l1 + ", endTime = " + (String)localObject);
            }
          }
          else if (paramString.length() < 15)
          {
            if (!QLog.isColorLevel()) {
              break label675;
            }
            QLog.i("SPLASH_ConfigServlet", 2, "parseXML | NearbyBanner md5 length < 15, cid = " + l1);
          }
        }
      }
      catch (Exception paramPicAndAdConf)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "parseXML | NearbyBanner parse exception,", paramPicAndAdConf);
        }
      }
      return;
      if (paramSet.contains(l1 + paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "parseXML | NearbyBanner " + l1 + " had been closed, throw it");
        }
      }
      else
      {
        localObject = new StringBuffer();
        int j = 0;
        while (j < localDocument.getElementsByTagName("url").item(i).getChildNodes().getLength())
        {
          ((StringBuffer)localObject).append(localDocument.getElementsByTagName("url").item(i).getChildNodes().item(j).getNodeValue());
          j += 1;
        }
        paramPicAndAdConf.a(paramPicAndAdConf.a(l1, str2, (byte)3, str1, ((StringBuffer)localObject).toString(), BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/" + "NearbyBannerPic" + "/" + paramString, l3 + "|" + l2, (short)k, paramString));
      }
      label675:
      i += 1;
    }
  }
  
  private void a(File paramFile, String paramString1, String paramString2)
  {
    ThreadManager.a(new hxr(this, paramFile, paramString1, paramString2));
  }
  
  private void a(String paramString, int paramInt)
  {
    try
    {
      paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
      Object localObject2 = (Element)paramString.getElementsByTagName("call_tab").item(0);
      String str1 = ((Element)localObject2).getElementsByTagName("wording").item(0).getFirstChild().getNodeValue();
      String str2 = ((Element)localObject2).getElementsByTagName("jump_url").item(0).getFirstChild().getNodeValue();
      Object localObject1 = ((Element)localObject2).getElementsByTagName("icon_img").item(0).getFirstChild().getNodeValue();
      localObject2 = ((Element)localObject2).getElementsByTagName("icon_md5").item(0).getFirstChild().getNodeValue();
      LightTalkTipsData.a(str1, str2);
      a(new File(LightTalkTipsData.d), (String)localObject1, (String)localObject2);
      localObject1 = (Element)paramString.getElementsByTagName("aio").item(0);
      paramString = ((Element)localObject1).getElementsByTagName("wording").item(0).getFirstChild().getNodeValue();
      str1 = ((Element)localObject1).getElementsByTagName("jump_url").item(0).getFirstChild().getNodeValue();
      str2 = ((Element)localObject1).getElementsByTagName("icon_img").item(0).getFirstChild().getNodeValue();
      localObject1 = ((Element)localObject1).getElementsByTagName("icon_md5").item(0).getFirstChild().getNodeValue();
      LightalkBlueTipsBarData.a(paramString, str1);
      a(new File(LightalkBlueTipsBarData.d), str2, (String)localObject1);
      SharedPreUtils.d(getAppRuntime().getApplication(), paramInt, d);
      return;
    }
    catch (Exception paramString)
    {
      do
      {
        paramString.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.i("SPLASH_ConfigServlet", 2, "parse lightalk xml  exception : " + paramString.getMessage());
    }
  }
  
  public static boolean a(String paramString)
  {
    return new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/ADPic/" + paramString).exists();
  }
  
  private static byte[] a(ConfigurationService.ReqGetConfig paramReqGetConfig)
  {
    paramReqGetConfig = paramReqGetConfig.toByteArray();
    long l = paramReqGetConfig.length;
    byte[] arrayOfByte = new byte[(int)l + 4];
    PkgTools.a(arrayOfByte, 0, 4L + l);
    PkgTools.a(arrayOfByte, 4, paramReqGetConfig, (int)l);
    return arrayOfByte;
  }
  
  public static byte[] a(FromServiceMsg paramFromServiceMsg)
  {
    int i = paramFromServiceMsg.getWupBuffer().length - 4;
    byte[] arrayOfByte = new byte[i];
    PkgTools.a(arrayOfByte, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    return arrayOfByte;
  }
  
  private static int b(String paramString1, String paramString2)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM-dd");
    try
    {
      long l = (localSimpleDateFormat.parse(paramString2).getTime() - localSimpleDateFormat.parse(paramString1).getTime()) / 86400000L;
      return (int)l;
    }
    catch (ParseException paramString1)
    {
      paramString1.printStackTrace();
    }
    return -1;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    d = paramString;
    a(paramQQAppInterface, 10);
  }
  
  private void b(String paramString, int paramInt)
  {
    label730:
    label733:
    label740:
    for (;;)
    {
      int i;
      long l1;
      String str1;
      String str2;
      int k;
      Object localObject1;
      Object localObject2;
      long l2;
      long l3;
      try
      {
        Document localDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
        NodeList localNodeList = localDocument.getElementsByTagName("pushbanner");
        paramString = "";
        i = 0;
        if (i < localNodeList.getLength())
        {
          l1 = Long.parseLong(localDocument.getElementsByTagName("channel").item(i).getFirstChild().getNodeValue());
          str1 = localDocument.getElementsByTagName("img").item(i).getFirstChild().getNodeValue();
          str2 = localDocument.getElementsByTagName("digest").item(i).getFirstChild().getNodeValue();
          k = Integer.parseInt(localDocument.getElementsByTagName("weight").item(i).getFirstChild().getNodeValue());
          localObject1 = localDocument.getElementsByTagName("md5").item(i).getFirstChild();
          if (localObject1 != null) {
            paramString = ((Node)localObject1).getNodeValue();
          }
          localObject1 = localDocument.getElementsByTagName("end").item(i).getFirstChild().getNodeValue();
          localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          l2 = ((SimpleDateFormat)localObject2).parse((String)localObject1).getTime();
          l3 = ((SimpleDateFormat)localObject2).parse(localDocument.getElementsByTagName("begin").item(i).getFirstChild().getNodeValue()).getTime();
          if (System.currentTimeMillis() > l2)
          {
            if (QLog.isColorLevel()) {
              QLog.i("SPLASH_ConfigServlet", 2, "this pushbanner is outdate , throw it");
            }
          }
          else
          {
            localObject1 = new StringBuffer();
            paramInt = 0;
            if (paramInt < localDocument.getElementsByTagName("url").item(i).getChildNodes().getLength())
            {
              ((StringBuffer)localObject1).append(localDocument.getElementsByTagName("url").item(i).getChildNodes().item(paramInt).getNodeValue());
              paramInt += 1;
              continue;
            }
            localObject1 = ((StringBuffer)localObject1).toString();
            localObject2 = ((QQAppInterface)getAppRuntime()).a().createEntityManager().a(ExpiredPushBanner.class);
            int j = 0;
            paramInt = 0;
            if (localObject2 != null)
            {
              localObject2 = ((List)localObject2).iterator();
              j = paramInt;
              if (((Iterator)localObject2).hasNext())
              {
                if (((ExpiredPushBanner)((Iterator)localObject2).next()).cid != l1) {
                  break label730;
                }
                paramInt = 1;
                break label740;
              }
            }
            if (j != 0)
            {
              if (!QLog.isColorLevel()) {
                break label733;
              }
              QLog.i("SPLASH_ConfigServlet", 2, "this pushbanner had been close or click , throw it");
            }
          }
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "push exception : " + paramString.getMessage());
        }
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "parse push: index = " + i + ", md5 = " + paramString);
      }
      if (paramString.length() < 15)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "this pushbanner md5 length < 15 .throw");
        }
      }
      else
      {
        localObject2 = BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/ADPic/" + paramString;
        if (!a(paramString)) {
          ThreadManager.a(new hxs(this, str1));
        }
        Config.a.a(Config.a.a(l1, str2, (byte)3, str1, (String)localObject1, (String)localObject2, l3 + "|" + l2, (short)k, paramString));
        break label733;
        break label740;
      }
      i += 1;
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    d = paramString;
    a(paramQQAppInterface, 51);
  }
  
  private void c(String paramString, int paramInt)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
        NodeList localNodeList = ((Document)localObject).getElementsByTagName("splash_birth");
        paramString = "";
        String str2 = "";
        float f2 = 0.0F;
        float f3 = 0.0F;
        String str1 = "";
        float f4 = 0.0F;
        float f1 = 0.0F;
        i = 0;
        float f5;
        if (i < localNodeList.getLength())
        {
          str2 = ((Document)localObject).getElementsByTagName("img").item(i).getFirstChild().getNodeValue();
          paramString = ((Document)localObject).getElementsByTagName("md5").item(i).getFirstChild().getNodeValue();
          f2 = Float.parseFloat(((Document)localObject).getElementsByTagName("x").item(i).getFirstChild().getNodeValue());
          f3 = Float.parseFloat(((Document)localObject).getElementsByTagName("y").item(i).getFirstChild().getNodeValue());
          f5 = Float.parseFloat(((Document)localObject).getElementsByTagName("width").item(i).getFirstChild().getNodeValue());
          float f6 = Float.parseFloat(((Document)localObject).getElementsByTagName("height").item(i).getFirstChild().getNodeValue());
          str1 = ((Document)localObject).getElementsByTagName("color").item(i).getFirstChild().getNodeValue();
          f4 = Float.parseFloat(((Document)localObject).getElementsByTagName("size").item(i).getFirstChild().getNodeValue());
          f1 = Float.parseFloat(((Document)localObject).getElementsByTagName("width").item(i).getFirstChild().getNodeValue());
          if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "birthday-splash parse result,img == " + str2 + " ,md5 = " + paramString + " ,x=" + f2 + " ,y=" + f3 + " ,width=" + f5 + " ,height=" + f6 + " ,color=" + str1 + " ,font_size=" + f4);
          }
        }
        else
        {
          if ((str2 != null) && (!str2.trim().equals("")))
          {
            localObject = getAppRuntime().getApplication().getFilesDir().getAbsolutePath() + "/" + d + "/" + "birthdayflashlogo.png";
            str2 = MsfSdkUtils.insertMtype("ConfigCheck", str2);
            f5 = f1;
            if (f1 < 0.0F) {
              f5 = 50.0F;
            }
            new hxt(this, str2, (String)localObject, paramInt, paramString, f2, f3, f5, str1, f4).start();
          }
          return;
        }
      }
      catch (Exception paramString)
      {
        return;
      }
      i += 1;
    }
  }
  
  public static void d(QQAppInterface paramQQAppInterface, String paramString)
  {
    d = paramString;
    a(paramQQAppInterface, 52);
  }
  
  private void d(String paramString, int paramInt)
  {
    for (;;)
    {
      int i;
      try
      {
        String str5 = getAppRuntime().getApplication().getFilesDir().getAbsolutePath() + "/splashpic/";
        Object localObject2 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
        NodeList localNodeList = ((Document)localObject2).getElementsByTagName("splash");
        String str4 = null;
        String str3 = null;
        Object localObject1 = null;
        paramString = "";
        String str2 = "";
        String str1 = "";
        i = 0;
        if (i < localNodeList.getLength())
        {
          str4 = ((Document)localObject2).getElementsByTagName("img").item(i).getFirstChild().getNodeValue();
          str3 = ((Document)localObject2).getElementsByTagName("begin").item(i).getFirstChild().getNodeValue();
          localObject1 = ((Document)localObject2).getElementsByTagName("end").item(i).getFirstChild().getNodeValue();
          paramString = ((Document)localObject2).getElementsByTagName("md5").item(i).getFirstChild().getNodeValue();
          str2 = ((Document)localObject2).getElementsByTagName("channel").item(i).getFirstChild().getNodeValue();
          str1 = ((Document)localObject2).getElementsByTagName("url").item(i).getFirstChild().getNodeValue();
          if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "parse result,img == " + str4 + " ,begin = " + str3 + " ,end=" + (String)localObject1 + ",md5=" + paramString + ",url=" + str1);
          }
        }
        else
        {
          if ((str4 == null) || (str4.trim().equals(""))) {
            break;
          }
          str4 = MsfSdkUtils.insertMtype("ConfigCheck", str4);
          localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          str3 = ((SimpleDateFormat)localObject2).parse(str3).getTime() + "|" + ((SimpleDateFormat)localObject2).parse((String)localObject1).getTime();
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "new splash: version = " + paramInt + ", time = " + str3 + ", md5 = " + paramString);
          }
          SharedPreUtils.a(getAppRuntime().getApplication(), paramInt, str3, paramString);
          new File(getAppRuntime().getApplication().getFilesDir().getAbsolutePath() + "/splashpic");
          if (((SimpleDateFormat)localObject2).parse((String)localObject1).getTime() < System.currentTimeMillis())
          {
            paramString = new File(str5 + paramString);
            if (paramString.exists()) {
              paramString.delete();
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("SPLASH_ConfigServlet", 2, "this splash is outdate, throw it");
            return;
          }
          localObject1 = new File(str5 + paramString);
          localObject2 = new File(str5 + str3 + "_" + paramString + "_" + str2);
          if (((File)localObject2).exists()) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "begin a thread try to download");
          }
          ThreadManager.a(new hxu(this, (File)localObject1, str4, paramString, (File)localObject2, str1, str5, str3, str2, str4));
          return;
        }
      }
      catch (Exception paramString)
      {
        return;
      }
      i += 1;
    }
  }
  
  public static void e(QQAppInterface paramQQAppInterface, String paramString)
  {
    d = paramString;
    a(paramQQAppInterface, 12);
  }
  
  public static void f(QQAppInterface paramQQAppInterface, String paramString)
  {
    d = paramString;
    a(paramQQAppInterface, 101);
  }
  
  public static void g(QQAppInterface paramQQAppInterface, String paramString)
  {
    d = paramString;
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet_birth", 2, "getBirthdaySplashConfig method called");
    }
    SharedPreUtils.a(paramQQAppInterface.getApplication(), paramString);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.a() != null))
    {
      e = paramQQAppInterface.c();
      new hxv(paramQQAppInterface).start();
    }
  }
  
  public static void h(QQAppInterface paramQQAppInterface, String paramString)
  {
    d = paramString;
    a(paramQQAppInterface, 18);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int j = 0;
    int i = 0;
    Object localObject = (QQAppInterface)getAppRuntime();
    int k = paramIntent.getIntExtra("k_cmd_type", 51);
    boolean bool = paramFromServiceMsg.isSuccess();
    if ((StatusManager)getAppRuntime().getManager(14) == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("SPLASH_ConfigServlet", 2, "received config response + cmd" + k);
      }
      switch (k)
      {
      default: 
        return;
      }
    } while (!bool);
    for (;;)
    {
      for (;;)
      {
        try
        {
          for (;;)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.i("SPLASH_ConfigServlet", 2, "response success");
              }
              if (paramFromServiceMsg.getWupBuffer() != null) {
                paramFromServiceMsg.putWupBuffer(a(paramFromServiceMsg));
              }
              paramIntent = new ConfigurationService.RespGetConfig();
              paramIntent.mergeFrom(paramFromServiceMsg.getWupBuffer());
              if (paramIntent.result.get() != 0) {
                break;
              }
              if ((paramIntent.config_list != null) && (paramIntent.config_list.size() > 0))
              {
                paramIntent = (ConfigurationService.Config)paramIntent.config_list.get(0);
                if (k == 51)
                {
                  if ((paramIntent != null) && (paramIntent.content_list != null) && (paramIntent.content_list.size() > 0))
                  {
                    paramFromServiceMsg = new File(getAppRuntime().getApplication().getFilesDir().getAbsolutePath() + "/splashpic");
                    if (!paramFromServiceMsg.exists()) {
                      paramFromServiceMsg.mkdirs();
                    }
                    do
                    {
                      do
                      {
                        paramFromServiceMsg = paramIntent.content_list.get().iterator();
                        while (paramFromServiceMsg.hasNext())
                        {
                          localObject = (String)paramFromServiceMsg.next();
                          if (QLog.isColorLevel()) {
                            QLog.i("SPLASH_ConfigServlet", 2, "config_content == " + (String)localObject);
                          }
                          d((String)localObject, paramIntent.version.get());
                          if (QLog.isColorLevel()) {
                            QLog.i("SPLASH_ConfigServlet", 2, "onreceive CMD_SPLASH_IMAGE version_back is " + paramIntent.version.get());
                          }
                        }
                      } while ((paramFromServiceMsg == null) || (!paramFromServiceMsg.isDirectory()));
                      paramFromServiceMsg = paramFromServiceMsg.listFiles();
                      j = paramFromServiceMsg.length;
                    } while (i >= j);
                    localObject = paramFromServiceMsg[i];
                    if ((localObject == null) || (!((File)localObject).exists())) {
                      break label2503;
                    }
                    ((File)localObject).delete();
                    break label2503;
                  }
                  if (paramIntent == null) {
                    break;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.i("SPLASH_ConfigServlet", 2, "splash content_list data error,so clear local splash data");
                  }
                  paramFromServiceMsg = new File(getAppRuntime().getApplication().getFilesDir().getAbsolutePath() + "/" + "flashlogo.png");
                  if (paramFromServiceMsg != null) {
                    paramFromServiceMsg.delete();
                  }
                  SharedPreUtils.a(getAppRuntime().getApplication(), paramIntent.version.get(), "1|2", "");
                  return;
                }
                if (k == 52)
                {
                  if ((paramIntent != null) && (paramIntent.content_list != null) && (paramIntent.content_list.size() > 0))
                  {
                    Config.a.b();
                    paramFromServiceMsg = paramIntent.content_list.get().iterator();
                    while (paramFromServiceMsg.hasNext())
                    {
                      localObject = (String)paramFromServiceMsg.next();
                      if (QLog.isColorLevel()) {
                        QLog.i("SPLASH_ConfigServlet", 2, "pushbanner config_content == " + (String)localObject);
                      }
                      b((String)localObject, paramIntent.version.get());
                    }
                    paramFromServiceMsg = new ConfigManager(getAppRuntime().getApplication(), d);
                    if (paramFromServiceMsg != null)
                    {
                      paramFromServiceMsg.b();
                      paramFromServiceMsg.c();
                    }
                    paramFromServiceMsg = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
                    paramFromServiceMsg.edit().putBoolean("reveive_newpb" + getAppRuntime().getAccount(), true).commit();
                    paramFromServiceMsg.edit().putBoolean("push_banner_display" + getAppRuntime().getAccount(), true).commit();
                    if (QLog.isColorLevel()) {
                      QLog.d("SPLASH_ConfigServlet", 2, "new banner: version = " + paramIntent.version.get());
                    }
                    SharedPreUtils.b(getAppRuntime().getApplication(), paramIntent.version.get(), d);
                    if (!QLog.isColorLevel()) {
                      break;
                    }
                    QLog.i("SPLASH_ConfigServlet", 2, "pushbanner onreceive CMD_PUSH_BANNER version_back is " + paramIntent.version.get());
                    return;
                  }
                  if (paramIntent == null) {
                    break;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.i("SPLASH_ConfigServlet", 2, "pushbanner content_list data error,so clear local pushbanner data");
                  }
                  Config.a.b();
                  Config.a.c();
                  paramFromServiceMsg = new ConfigManager(getAppRuntime().getApplication(), d);
                  if (paramFromServiceMsg != null)
                  {
                    paramFromServiceMsg.b();
                    paramFromServiceMsg.c();
                  }
                  BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putBoolean("push_banner_display" + getAppRuntime().getAccount(), false).commit();
                  SharedPreUtils.b(getAppRuntime().getApplication(), paramIntent.version.get(), d);
                  return;
                }
                if (k == 12)
                {
                  paramFromServiceMsg = (NearbyBannerManager)((QQAppInterface)getAppRuntime()).getManager(70);
                  localObject = paramFromServiceMsg.a();
                  PicAndAdConf localPicAndAdConf = new PicAndAdConf((short)21, (byte)2);
                  if ((paramIntent != null) && (paramIntent.content_list != null) && (paramIntent.content_list.size() > 0))
                  {
                    Iterator localIterator = paramIntent.content_list.get().iterator();
                    while (localIterator.hasNext())
                    {
                      String str = (String)localIterator.next();
                      if (QLog.isColorLevel()) {
                        QLog.i("SPLASH_ConfigServlet", 2, "NearbyBanner's configContent:" + str);
                      }
                      a(localPicAndAdConf, str, (Set)localObject);
                    }
                  }
                  if (QLog.isColorLevel()) {
                    QLog.i("SPLASH_ConfigServlet", 2, "NearbyBanner onreceive, content count = " + paramIntent.content_list.get().size() + " , item count = " + localPicAndAdConf.b() + ", version = " + paramIntent.version.get());
                  }
                  paramFromServiceMsg.a(localPicAndAdConf, paramIntent.version.get());
                  return;
                }
                if (k == 3)
                {
                  if ((paramIntent == null) || (paramIntent.content_list == null) || (paramIntent.content_list.size() <= 0)) {
                    break;
                  }
                  paramFromServiceMsg = (String)paramIntent.content_list.get(0);
                  if (QLog.isColorLevel()) {
                    QLog.i("SPLASH_ConfigServlet", 2, "birthday-splash config_content == " + paramFromServiceMsg);
                  }
                  c(paramFromServiceMsg, paramIntent.version.get());
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.i("SPLASH_ConfigServlet", 2, "birthday-splash onreceive cmd==3 version_back is " + paramIntent.version.get());
                  return;
                }
                if ((k != 5) || (paramIntent == null) || (paramIntent.content_list == null) || (paramIntent.content_list.size() <= 0)) {
                  break;
                }
                paramFromServiceMsg = new ArrayList();
                i = j;
                if (i < paramIntent.content_list.size())
                {
                  localObject = (String)paramIntent.content_list.get(i);
                  if (QLog.isDevelopLevel()) {
                    QLog.d("QQOperateVoIP", 4, "config_content == " + (String)localObject);
                  }
                  localObject = a((String)localObject);
                  if (localObject == null) {
                    break label2510;
                  }
                  paramFromServiceMsg.add(localObject);
                  break label2510;
                }
                QQOperateManager.a((QQAppInterface)getAppRuntime()).a((QQAppInterface)getAppRuntime(), paramFromServiceMsg);
                SharedPreUtils.a(getAppRuntime().getApplication(), getAppRuntime().getAccount(), paramIntent.version.get());
                return;
              }
              if (QLog.isColorLevel()) {
                QLog.i("SPLASH_ConfigServlet", 2, "config_list empty data");
              }
              if (k != 51) {
                break;
              }
              paramIntent = getAppRuntime().getApplication().getFilesDir().getAbsolutePath() + "/splashpic/";
              paramFromServiceMsg = new File(paramIntent);
              if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.exists()) || (!paramFromServiceMsg.isDirectory())) {
                break;
              }
              paramFromServiceMsg = paramFromServiceMsg.listFiles();
              if (paramFromServiceMsg == null) {
                break;
              }
              j = paramFromServiceMsg.length;
              i = 0;
              while (i < j)
              {
                ThreadManager.a(new hxq(this, paramFromServiceMsg[i], paramIntent));
                i += 1;
              }
              if (QLog.isColorLevel()) {
                QLog.i("SPLASH_ConfigServlet", 2, "received deviceprofile info response: " + bool);
              }
              if (!bool) {
                break;
              }
              if (paramFromServiceMsg.getWupBuffer() != null) {
                paramFromServiceMsg.putWupBuffer(a(paramFromServiceMsg));
              }
              paramIntent = new ConfigurationService.RespGetConfig();
              try
              {
                paramIntent.mergeFrom(paramFromServiceMsg.getWupBuffer());
                if ((paramIntent.result.get() != 0) || (paramIntent.config_list == null) || (paramIntent.config_list.size() <= 0)) {
                  break;
                }
                DeviceProfileManager.a().a(paramIntent, "");
                return;
              }
              catch (InvalidProtocolBufferMicroException paramIntent)
              {
                if (QLog.isDevelopLevel()) {
                  QLog.e("SPLASH_ConfigServlet", 4, "error: " + paramIntent.toString());
                }
                paramIntent.printStackTrace();
                return;
              }
            }
            if (!bool) {
              break;
            }
            paramIntent = paramFromServiceMsg.getWupBuffer();
            if ((paramIntent == null) || (paramIntent.length <= 4)) {
              break;
            }
            paramIntent = a(paramFromServiceMsg);
            paramFromServiceMsg = new ConfigurationService.RespGetConfig();
            try
            {
              paramFromServiceMsg.mergeFrom(paramIntent);
              if (paramFromServiceMsg.result.get() != 0) {
                break;
              }
              if ((paramFromServiceMsg.config_list == null) || (paramFromServiceMsg.config_list.size() <= 0)) {
                break label2496;
              }
              paramIntent = (ConfigurationService.Config)paramFromServiceMsg.config_list.get(0);
              if ((paramIntent == null) || (paramIntent.type == null) || (paramIntent.type.get() != 10)) {
                break;
              }
              if ((paramIntent.content_list == null) || (paramIntent.content_list.size() <= 0)) {
                break label2491;
              }
              paramFromServiceMsg = paramIntent.content_list.get();
              if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
              {
                BmqqSegmentUtil.a((String)paramFromServiceMsg.get(0));
                i = paramIntent.version.get();
                SharedPreUtils.a(getAppRuntime().getApplication(), i);
                return;
              }
            }
            catch (InvalidProtocolBufferMicroException paramIntent)
            {
              if (QLog.isColorLevel()) {
                QLog.e("SPLASH_ConfigServlet", 2, "error: " + paramIntent.toString());
              }
              paramIntent.printStackTrace();
              return;
            }
          }
          BmqqSegmentUtil.a(null);
          continue;
          if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "received enterconfig info response: " + bool);
          }
          if (!bool) {
            break;
          }
          paramIntent = paramFromServiceMsg.getWupBuffer();
          if ((paramIntent == null) || (paramIntent.length <= 4)) {
            break;
          }
          paramIntent = a(paramFromServiceMsg);
          paramFromServiceMsg = new ConfigurationService.RespGetConfig();
          try
          {
            paramFromServiceMsg.mergeFrom(paramIntent);
            EnterConfigManager.a(BaseApplication.getContext(), ((QQAppInterface)localObject).getAccount()).a(paramFromServiceMsg);
            return;
          }
          catch (Exception paramIntent)
          {
            if (QLog.isColorLevel()) {
              QLog.e("SPLASH_ConfigServlet", 2, "error: " + paramIntent.toString());
            }
            paramIntent.printStackTrace();
            return;
          }
          a(paramIntent, paramFromServiceMsg);
          return;
        }
        catch (Exception paramIntent)
        {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received lightlakconfig info response: " + bool);
        }
        if (!bool) {
          break;
        }
        try
        {
          if (paramFromServiceMsg.getWupBuffer() != null) {
            paramFromServiceMsg.putWupBuffer(a(paramFromServiceMsg));
          }
          paramIntent = new ConfigurationService.RespGetConfig();
          paramIntent.mergeFrom(paramFromServiceMsg.getWupBuffer());
          if ((paramIntent.result.get() != 0) || (paramIntent.config_list == null) || (paramIntent.config_list.size() <= 0)) {
            break;
          }
          paramIntent = (ConfigurationService.Config)paramIntent.config_list.get(0);
          if ((paramIntent == null) || (paramIntent.content_list == null) || (paramIntent.content_list.size() <= 0)) {
            break;
          }
          paramFromServiceMsg = paramIntent.content_list.get().iterator();
          if (!paramFromServiceMsg.hasNext()) {
            break;
          }
          localObject = (String)paramFromServiceMsg.next();
          if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "lightalk tips config_content == " + (String)localObject);
          }
          a((String)localObject, paramIntent.version.get());
          continue;
          paramFromServiceMsg = null;
        }
        catch (Exception paramIntent)
        {
          if (QLog.isColorLevel()) {
            QLog.e("SPLASH_ConfigServlet", 2, "error: " + paramIntent.toString());
          }
          paramIntent.printStackTrace();
          return;
        }
      }
      label2491:
      continue;
      label2496:
      paramIntent = null;
      continue;
      label2503:
      i += 1;
      continue;
      label2510:
      i += 1;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "send config request");
    }
    Object localObject1 = (QQAppInterface)getAppRuntime();
    int i = paramIntent.getIntExtra("k_cmd_type", 51);
    ConfigurationService.ConfigSeq localConfigSeq = new ConfigurationService.ConfigSeq();
    localConfigSeq.type.set(i);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "send config request");
    }
    paramIntent = new ConfigurationService.ReqGetConfig();
    switch (i)
    {
    }
    for (;;)
    {
      paramIntent = a(paramIntent);
      if ((paramIntent != null) && (paramIntent.length > 0)) {
        paramPacket.putSendData(paramIntent);
      }
      paramPacket.setSSOCommand("ConfigurationService.ReqGetConfig");
      return;
      if (i == 51) {
        localConfigSeq.version.set(SharedPreUtils.b(((QQAppInterface)localObject1).a()));
      }
      for (;;)
      {
        localObject1 = new ConfigurationService.DeviceInfo();
        localObject2 = new ConfigurationService.Screen();
        ((ConfigurationService.Screen)localObject2).setHasFlag(true);
        ((ConfigurationService.Screen)localObject2).width.set((int)DeviceInfoUtil.f());
        ((ConfigurationService.Screen)localObject2).height.set((int)DeviceInfoUtil.g());
        ((ConfigurationService.DeviceInfo)localObject1).setHasFlag(true);
        ((ConfigurationService.DeviceInfo)localObject1).screen = ((ConfigurationService.Screen)localObject2);
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(localConfigSeq);
        paramIntent.setHasFlag(true);
        paramIntent.device_info = ((ConfigurationService.DeviceInfo)localObject1);
        paramIntent.seq_list.addAll((Collection)localObject2);
        break;
        if (i == 52)
        {
          localConfigSeq.version.set(SharedPreUtils.b(((QQAppInterface)localObject1).a(), d));
        }
        else if (i == 3)
        {
          localConfigSeq.version.set(SharedPreUtils.c(((QQAppInterface)localObject1).a(), d));
        }
        else if (i == 12)
        {
          localObject1 = (NearbyBannerManager)((QQAppInterface)localObject1).getManager(70);
          localConfigSeq.version.set(((NearbyBannerManager)localObject1).a());
        }
        else if (i == 18)
        {
          localConfigSeq.version.set(SharedPreUtils.f(((QQAppInterface)localObject1).a(), d));
        }
        else
        {
          localConfigSeq.version.set(0);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("SPLASH_ConfigServlet", 2, "send deviceprofile info request");
      }
      paramIntent = DeviceProfileManager.a((AppInterface)localObject1, true);
      continue;
      Object localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(localConfigSeq);
      localConfigSeq.version.set(SharedPreUtils.d(((QQAppInterface)localObject1).a(), ((QQAppInterface)localObject1).a()));
      paramIntent.setHasFlag(true);
      paramIntent.seq_list.addAll((Collection)localObject2);
      continue;
      paramIntent.setHasFlag(true);
      localConfigSeq.version.set(SharedPreUtils.a(((QQAppInterface)localObject1).a()));
      paramIntent.seq_list.add(localConfigSeq);
      continue;
      paramIntent.setHasFlag(true);
      localConfigSeq.version.set(SharedPreUtils.a(((QQAppInterface)localObject1).a(), ((QQAppInterface)localObject1).getAccount()));
      paramIntent.seq_list.add(localConfigSeq);
      continue;
      paramIntent.setHasFlag(true);
      localConfigSeq.version.set(SharedPreUtils.e(((QQAppInterface)localObject1).a(), ((QQAppInterface)localObject1).getAccount()));
      paramIntent.seq_list.add(localConfigSeq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.splashlogo.ConfigServlet
 * JD-Core Version:    0.7.0.1
 */