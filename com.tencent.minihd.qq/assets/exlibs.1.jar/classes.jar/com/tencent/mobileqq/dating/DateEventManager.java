package com.tencent.mobileqq.dating;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.NotificationCompat.Builder;
import appoint.define.appoint_define.DateEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DateEventMsg;
import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.CustomHandler;
import hzk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DateEventManager
  implements Handler.Callback
{
  public static final int a = 4097;
  public static final String a = "dating_notification_tag";
  public static final int b = 20;
  private static final String jdField_b_of_type_JavaLangString = "read_event_id";
  private static final int jdField_c_of_type_Int = 100;
  private static final String jdField_c_of_type_JavaLangString = "last_event_id";
  private static final int d = 5000;
  private static final int e = 5;
  private static final int h = 1;
  private static final int i = 2;
  private static final int j = 3;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private DatingManager jdField_a_of_type_ComTencentMobileqqDatingDatingManager;
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private int f;
  private int g;
  
  public DateEventManager(DatingManager paramDatingManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager = paramDatingManager;
    this.jdField_a_of_type_AndroidOsHandler = new CustomHandler(ThreadManager.a(), this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList(20);
    this.f = 0;
    this.g = 0;
  }
  
  private DateEventMsg a(long paramLong)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
          if (localIterator.hasNext())
          {
            DateEventMsg localDateEventMsg = (DateEventMsg)localIterator.next();
            if ((localDateEventMsg == null) || (localDateEventMsg.event_id != paramLong)) {
              continue;
            }
            ??? = localDateEventMsg;
            if (localDateEventMsg == null)
            {
              ??? = localDateEventMsg;
              if (paramLong >= this.jdField_a_of_type_Long) {
                ??? = (DateEventMsg)this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DateEventMsg.class, String.valueOf(paramLong));
              }
            }
            return ???;
          }
        }
      }
      Object localObject2 = null;
    }
  }
  
  private void a(DateEventMsg paramDateEventMsg)
  {
    if (paramDateEventMsg == null) {
      return;
    }
    if (paramDateEventMsg.bReaded == 0) {}
    for (;;)
    {
      DatingInfo localDatingInfo;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        int m = this.jdField_a_of_type_JavaUtilList.size();
        k = 0;
        if (k >= m) {
          break label400;
        }
        if (paramDateEventMsg.compareTo((DateEventMsg)this.jdField_a_of_type_JavaUtilList.get(k)) >= 0)
        {
          if (k >= 0)
          {
            this.jdField_a_of_type_JavaUtilList.add(k, paramDateEventMsg);
            if (this.jdField_a_of_type_JavaUtilList.size() > 100) {
              this.jdField_a_of_type_JavaUtilList.remove(100);
            }
            this.g += 1;
            if ((paramDateEventMsg.type == 4) || (paramDateEventMsg.type == 5))
            {
              ??? = DatingUtil.a(paramDateEventMsg.date_info);
              localDatingInfo = this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.a().a((String)???, true, false, true);
              if (localDatingInfo != null)
              {
                if ((paramDateEventMsg.type != 4) || (localDatingInfo.datingSelFlag == 1)) {
                  break label316;
                }
                localDatingInfo.datingSelFlag = 1;
                bool = true;
                if (bool)
                {
                  if (localDatingInfo.getStatus() != 1000) {
                    break label344;
                  }
                  this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localDatingInfo);
                }
                DatingUtil.a("saveDateEventMsg", new Object[] { Integer.valueOf(paramDateEventMsg.type), Boolean.valueOf(bool), ???, Integer.valueOf(localDatingInfo.datingSelFlag), Integer.valueOf(localDatingInfo.datingStatus) });
              }
            }
            if (paramDateEventMsg.getStatus() != 1000) {
              break label371;
            }
            this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramDateEventMsg);
          }
        }
        else
        {
          k += 1;
          continue;
        }
        this.jdField_a_of_type_JavaUtilList.add(paramDateEventMsg);
      }
      label316:
      if ((paramDateEventMsg.type == 5) && (localDatingInfo.datingStatus == 0))
      {
        localDatingInfo.datingStatus = 2;
        bool = true;
        continue;
        label344:
        if (localDatingInfo.getStatus() == 1003) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localDatingInfo);
        continue;
        label371:
        if (paramDateEventMsg.getStatus() == 1003) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramDateEventMsg);
        return;
      }
      boolean bool = false;
      continue;
      label400:
      int k = -1;
    }
  }
  
  /* Error */
  private void a(DateEventMsg paramDateEventMsg, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 194
    //   4: iconst_2
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: ldc 196
    //   12: aastore
    //   13: dup
    //   14: iconst_1
    //   15: lload_2
    //   16: invokestatic 201	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   19: aastore
    //   20: invokestatic 203	com/tencent/mobileqq/dating/DatingUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   23: aload_1
    //   24: astore 4
    //   26: aload_1
    //   27: ifnonnull +12 -> 39
    //   30: new 94	com/tencent/mobileqq/data/DateEventMsg
    //   33: dup
    //   34: invokespecial 204	com/tencent/mobileqq/data/DateEventMsg:<init>	()V
    //   37: astore 4
    //   39: aload 4
    //   41: invokevirtual 208	com/tencent/mobileqq/data/DateEventMsg:getTableName	()Ljava/lang/String;
    //   44: astore_1
    //   45: new 210	android/content/ContentValues
    //   48: dup
    //   49: invokespecial 211	android/content/ContentValues:<init>	()V
    //   52: astore 4
    //   54: aload 4
    //   56: ldc 212
    //   58: iconst_1
    //   59: invokestatic 217	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   62: invokevirtual 221	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Byte;)V
    //   65: aload_0
    //   66: getfield 44	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_ComTencentMobileqqDatingDatingManager	Lcom/tencent/mobileqq/dating/DatingManager;
    //   69: getfield 102	com/tencent/mobileqq/dating/DatingManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   72: aload_1
    //   73: aload 4
    //   75: ldc 223
    //   77: iconst_2
    //   78: anewarray 104	java/lang/String
    //   81: dup
    //   82: iconst_0
    //   83: lload_2
    //   84: invokestatic 108	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   87: aastore
    //   88: dup
    //   89: iconst_1
    //   90: iconst_0
    //   91: invokestatic 226	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   94: aastore
    //   95: invokevirtual 229	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)Z
    //   98: pop
    //   99: aload_0
    //   100: monitorexit
    //   101: return
    //   102: astore_1
    //   103: aload_1
    //   104: invokevirtual 232	java/lang/Exception:printStackTrace	()V
    //   107: ldc 194
    //   109: iconst_2
    //   110: anewarray 4	java/lang/Object
    //   113: dup
    //   114: iconst_0
    //   115: ldc 196
    //   117: aastore
    //   118: dup
    //   119: iconst_1
    //   120: aload_1
    //   121: invokevirtual 235	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   124: aastore
    //   125: invokestatic 203	com/tencent/mobileqq/dating/DatingUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: goto -29 -> 99
    //   131: astore_1
    //   132: aload_0
    //   133: monitorexit
    //   134: aload_1
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	DateEventManager
    //   0	136	1	paramDateEventMsg	DateEventMsg
    //   0	136	2	paramLong	long
    //   24	50	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   39	99	102	java/lang/Exception
    //   2	23	131	finally
    //   30	39	131	finally
    //   39	99	131	finally
    //   103	128	131	finally
  }
  
  private void a(boolean paramBoolean, DateEventMsg paramDateEventMsg)
  {
    DatingUtil.a("notifyNewMsg", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.g), paramDateEventMsg });
    int k = this.g;
    Object localObject = paramDateEventMsg;
    if (paramDateEventMsg == null) {
      localObject = a();
    }
    Context localContext = BaseApplicationImpl.getContext();
    if (localContext == null)
    {
      paramDateEventMsg = (DatingHandler)this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(40);
      if (paramDateEventMsg == null) {
        break label452;
      }
      paramDateEventMsg.b();
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      return;
      if (k == 0)
      {
        paramDateEventMsg = (NotificationManager)localContext.getSystemService("notification");
        if (paramDateEventMsg == null) {
          break;
        }
        paramDateEventMsg.cancel("dating_notification_tag", 4097);
        break;
      }
      if ((localObject == null) || (!paramBoolean) || ((!this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause) && (!this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop))) {
        break;
      }
      localObject = ((DateEventMsg)localObject).getDescStr(localContext, true);
      if (k == 1)
      {
        paramDateEventMsg = localContext.getString(2131369656);
        label183:
        Bitmap localBitmap = BitmapManager.a(localContext.getResources(), 2130840223);
        paramDateEventMsg = new NotificationCompat.Builder(localContext).setContentTitle(paramDateEventMsg).setContentText((CharSequence)localObject).setAutoCancel(true).setSmallIcon(BaseApplicationImpl.appnewmsgicon).setTicker((CharSequence)localObject).setWhen(System.currentTimeMillis());
        if (localBitmap == null) {
          break label424;
        }
        paramDateEventMsg.setLargeIcon(localBitmap);
      }
      for (;;)
      {
        if (Build.VERSION.SDK_INT < 11) {
          paramDateEventMsg.setSmallIcon(2130840223);
        }
        localObject = new Intent(localContext, DateEventMsgActivity.class);
        ((Intent)localObject).putExtra("from", 1);
        ((Intent)localObject).addFlags(335544320);
        paramDateEventMsg.setContentIntent(PendingIntent.getActivity(localContext, 0, (Intent)localObject, 134217728));
        paramDateEventMsg = paramDateEventMsg.build();
        paramDateEventMsg.flags |= 0x10;
        paramDateEventMsg.defaults |= 0x1;
        paramDateEventMsg.defaults |= 0x4;
        paramDateEventMsg.icon = 2130840223;
        localObject = (NotificationManager)localContext.getSystemService("notification");
        if (localObject == null) {
          break;
        }
        ((NotificationManager)localObject).cancel("dating_notification_tag", 4097);
        ((NotificationManager)localObject).notify("dating_notification_tag", 4097, paramDateEventMsg);
        break;
        paramDateEventMsg = String.format(localContext.getString(2131369750), new Object[] { Integer.valueOf(k) });
        break label183;
        label424:
        localObject = BitmapManager.a(localContext.getResources(), 2130840223);
        if (localObject != null) {
          paramDateEventMsg.setLargeIcon((Bitmap)localObject);
        }
      }
      label452:
      DatingUtil.b("notifyNewMsg", new Object[] { "dh is null" });
    }
  }
  
  private boolean a()
  {
    DatingHandler localDatingHandler = (DatingHandler)this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(40);
    if (localDatingHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 30000L);
      localDatingHandler.a(this.b, this.jdField_a_of_type_Long, 100);
    }
    for (boolean bool = true;; bool = false)
    {
      DatingUtil.a("startFetchUnreadEvents", new Object[] { Boolean.valueOf(bool) });
      return bool;
      DatingUtil.b("MSG_GET_MORE_EVENT", new Object[] { "dh is null", Long.valueOf(this.b) });
    }
  }
  
  private List b()
  {
    try
    {
      long l = this.jdField_a_of_type_Long;
      List localList = this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DateEventMsg.class, false, "event_id > ? and bDeleted = ? and bReaded = ? ", new String[] { String.valueOf(l), String.valueOf(0), String.valueOf(0) }, null, null, "event_id desc", String.valueOf(300));
      return localList;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        DatingUtil.b("DateEventManager", new Object[] { "getUnreadEventListFromDB", localException.getMessage() });
        Object localObject1 = null;
      }
    }
    finally {}
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 436	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_Boolean	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: iconst_1
    //   10: putfield 436	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_Boolean	Z
    //   13: aload_0
    //   14: getfield 44	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_ComTencentMobileqqDatingDatingManager	Lcom/tencent/mobileqq/dating/DatingManager;
    //   17: getfield 256	com/tencent/mobileqq/dating/DatingManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokevirtual 440	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   23: astore 6
    //   25: aload_0
    //   26: aload 6
    //   28: ldc 16
    //   30: lconst_0
    //   31: invokeinterface 446 4 0
    //   36: putfield 71	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_Long	J
    //   39: aload_0
    //   40: aload 6
    //   42: ldc 20
    //   44: lconst_0
    //   45: invokeinterface 446 4 0
    //   50: putfield 417	com/tencent/mobileqq/dating/DateEventManager:b	J
    //   53: aload_0
    //   54: invokespecial 448	com/tencent/mobileqq/dating/DateEventManager:b	()Ljava/util/List;
    //   57: astore 6
    //   59: aload 6
    //   61: ifnonnull +78 -> 139
    //   64: iconst_0
    //   65: istore_1
    //   66: iconst_0
    //   67: istore_2
    //   68: iload_2
    //   69: iload_1
    //   70: if_icmpge +80 -> 150
    //   73: aload 6
    //   75: iload_2
    //   76: invokeinterface 122 2 0
    //   81: checkcast 94	com/tencent/mobileqq/data/DateEventMsg
    //   84: astore 7
    //   86: aload 7
    //   88: ifnull +44 -> 132
    //   91: aload_0
    //   92: getfield 63	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   95: invokeinterface 78 1 0
    //   100: bipush 100
    //   102: if_icmpge +20 -> 122
    //   105: aload 7
    //   107: invokevirtual 451	com/tencent/mobileqq/data/DateEventMsg:init	()V
    //   110: aload_0
    //   111: getfield 63	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   114: aload 7
    //   116: invokeinterface 186 2 0
    //   121: pop
    //   122: aload_0
    //   123: aload_0
    //   124: getfield 67	com/tencent/mobileqq/dating/DateEventManager:g	I
    //   127: iconst_1
    //   128: iadd
    //   129: putfield 67	com/tencent/mobileqq/dating/DateEventManager:g	I
    //   132: iload_2
    //   133: iconst_1
    //   134: iadd
    //   135: istore_2
    //   136: goto -68 -> 68
    //   139: aload 6
    //   141: invokeinterface 78 1 0
    //   146: istore_1
    //   147: goto -81 -> 66
    //   150: ldc_w 452
    //   153: iconst_3
    //   154: anewarray 4	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: aload_0
    //   160: getfield 67	com/tencent/mobileqq/dating/DateEventManager:g	I
    //   163: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   166: aastore
    //   167: dup
    //   168: iconst_1
    //   169: aload_0
    //   170: getfield 71	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_Long	J
    //   173: invokestatic 201	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   176: aastore
    //   177: dup
    //   178: iconst_2
    //   179: aload_0
    //   180: getfield 417	com/tencent/mobileqq/dating/DateEventManager:b	J
    //   183: invokestatic 201	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   186: aastore
    //   187: invokestatic 203	com/tencent/mobileqq/dating/DatingUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   190: new 94	com/tencent/mobileqq/data/DateEventMsg
    //   193: dup
    //   194: invokespecial 204	com/tencent/mobileqq/data/DateEventMsg:<init>	()V
    //   197: invokevirtual 208	com/tencent/mobileqq/data/DateEventMsg:getTableName	()Ljava/lang/String;
    //   200: astore 9
    //   202: aload_0
    //   203: getfield 44	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_ComTencentMobileqqDatingDatingManager	Lcom/tencent/mobileqq/dating/DatingManager;
    //   206: getfield 102	com/tencent/mobileqq/dating/DatingManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   209: iconst_0
    //   210: aload 9
    //   212: iconst_1
    //   213: anewarray 104	java/lang/String
    //   216: dup
    //   217: iconst_0
    //   218: ldc_w 454
    //   221: aastore
    //   222: aconst_null
    //   223: aconst_null
    //   224: aconst_null
    //   225: aconst_null
    //   226: aconst_null
    //   227: aconst_null
    //   228: invokevirtual 457	com/tencent/mobileqq/persistence/EntityManager:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   231: astore 7
    //   233: aload 7
    //   235: ifnull +243 -> 478
    //   238: aload 7
    //   240: astore 6
    //   242: aload 7
    //   244: invokeinterface 462 1 0
    //   249: ifeq +229 -> 478
    //   252: aload 7
    //   254: astore 6
    //   256: aload 7
    //   258: iconst_0
    //   259: invokeinterface 465 2 0
    //   264: lstore_3
    //   265: lload_3
    //   266: l2i
    //   267: istore_1
    //   268: aload 7
    //   270: ifnull +205 -> 475
    //   273: aload 7
    //   275: invokeinterface 468 1 0
    //   280: iload_1
    //   281: sipush 5000
    //   284: if_icmple -277 -> 7
    //   287: new 470	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 471	java/lang/StringBuilder:<init>	()V
    //   294: ldc_w 473
    //   297: invokevirtual 477	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload 9
    //   302: invokevirtual 477	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: ldc_w 479
    //   308: invokevirtual 477	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: invokevirtual 482	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: astore 6
    //   316: aload_0
    //   317: getfield 44	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_ComTencentMobileqqDatingDatingManager	Lcom/tencent/mobileqq/dating/DatingManager;
    //   320: getfield 102	com/tencent/mobileqq/dating/DatingManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   323: aload 6
    //   325: invokevirtual 485	com/tencent/mobileqq/persistence/EntityManager:b	(Ljava/lang/String;)Z
    //   328: istore 5
    //   330: ldc_w 487
    //   333: iconst_4
    //   334: anewarray 4	java/lang/Object
    //   337: dup
    //   338: iconst_0
    //   339: iload 5
    //   341: invokestatic 176	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   344: aastore
    //   345: dup
    //   346: iconst_1
    //   347: iload_1
    //   348: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   351: aastore
    //   352: dup
    //   353: iconst_2
    //   354: sipush 5000
    //   357: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   360: aastore
    //   361: dup
    //   362: iconst_3
    //   363: aload 6
    //   365: aastore
    //   366: invokestatic 182	com/tencent/mobileqq/dating/DatingUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   369: return
    //   370: astore 8
    //   372: aconst_null
    //   373: astore 7
    //   375: aload 7
    //   377: astore 6
    //   379: ldc_w 489
    //   382: iconst_1
    //   383: anewarray 4	java/lang/Object
    //   386: dup
    //   387: iconst_0
    //   388: aload 8
    //   390: invokevirtual 235	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   393: aastore
    //   394: invokestatic 203	com/tencent/mobileqq/dating/DatingUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   397: aload 7
    //   399: ifnull +71 -> 470
    //   402: aload 7
    //   404: invokeinterface 468 1 0
    //   409: iconst_0
    //   410: istore_1
    //   411: goto -131 -> 280
    //   414: astore 7
    //   416: aconst_null
    //   417: astore 6
    //   419: aload 6
    //   421: ifnull +10 -> 431
    //   424: aload 6
    //   426: invokeinterface 468 1 0
    //   431: aload 7
    //   433: athrow
    //   434: astore 7
    //   436: ldc_w 487
    //   439: iconst_1
    //   440: anewarray 4	java/lang/Object
    //   443: dup
    //   444: iconst_0
    //   445: aload 7
    //   447: invokevirtual 235	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   450: aastore
    //   451: invokestatic 203	com/tencent/mobileqq/dating/DatingUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   454: iconst_0
    //   455: istore 5
    //   457: goto -127 -> 330
    //   460: astore 7
    //   462: goto -43 -> 419
    //   465: astore 8
    //   467: goto -92 -> 375
    //   470: iconst_0
    //   471: istore_1
    //   472: goto -192 -> 280
    //   475: goto -195 -> 280
    //   478: iconst_0
    //   479: istore_1
    //   480: goto -212 -> 268
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	483	0	this	DateEventManager
    //   65	415	1	k	int
    //   67	69	2	m	int
    //   264	2	3	l	long
    //   328	128	5	bool	boolean
    //   23	402	6	localObject1	Object
    //   84	319	7	localObject2	Object
    //   414	18	7	localObject3	Object
    //   434	12	7	localException1	Exception
    //   460	1	7	localObject4	Object
    //   370	19	8	localException2	Exception
    //   465	1	8	localException3	Exception
    //   200	101	9	str	String
    // Exception table:
    //   from	to	target	type
    //   202	233	370	java/lang/Exception
    //   202	233	414	finally
    //   316	330	434	java/lang/Exception
    //   242	252	460	finally
    //   256	265	460	finally
    //   379	397	460	finally
    //   242	252	465	java/lang/Exception
    //   256	265	465	java/lang/Exception
  }
  
  private void c()
  {
    try
    {
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
      localEditor.putLong("read_event_id", this.jdField_a_of_type_Long);
      localEditor.putLong("last_event_id", this.b);
      DatingUtil.a("MSG_SAVE_FLAG", new Object[] { Boolean.valueOf(localEditor.commit()), Long.valueOf(this.b), Long.valueOf(this.jdField_a_of_type_Long) });
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int a()
  {
    return this.g;
  }
  
  public DateEventMsg a()
  {
    DateEventMsg localDateEventMsg = null;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
        localDateEventMsg = (DateEventMsg)this.jdField_a_of_type_JavaUtilList.get(0);
      }
      return localDateEventMsg;
    }
  }
  
  public List a()
  {
    DatingUtil.a("getUnreadEventMsg", new Object[] { Integer.valueOf(this.g), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
    int k;
    Object localObject2;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      k = this.jdField_a_of_type_JavaUtilList.size();
      if (k < this.g)
      {
        List localList1 = b();
        if ((localList1 != null) && (localList1.size() > 0))
        {
          localObject2 = localList1.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            DateEventMsg localDateEventMsg = (DateEventMsg)((Iterator)localObject2).next();
            if (localDateEventMsg != null) {
              localDateEventMsg.init();
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (k > 0) {
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (localObject1.size() != 0) {}
        }
        else
        {
          localObject2 = new ArrayList(20);
          ((List)localObject2).addAll(this.jdField_a_of_type_JavaUtilList);
        }
      }
      this.jdField_a_of_type_Long = this.b;
      this.jdField_a_of_type_JavaUtilList.clear();
      this.g = 0;
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localMessage = Message.obtain();
        localMessage.what = 3;
        localMessage.obj = ((List)localObject2).get(0);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
        a();
        a(false, null);
      }
      return localObject2;
      Message localMessage = null;
    }
  }
  
  public void a()
  {
    boolean bool1 = this.jdField_a_of_type_AndroidOsHandler.hasMessages(2);
    boolean bool2 = this.jdField_a_of_type_AndroidOsHandler.hasMessages(3);
    DatingUtil.a("DateEventManager.onDestory", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(this.g), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    NotificationManager localNotificationManager = (NotificationManager)BaseApplicationImpl.getContext().getSystemService("notification");
    if (localNotificationManager != null) {
      localNotificationManager.cancel("dating_notification_tag", 4097);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((bool1) || (bool2)) {
      ThreadManager.a().post(new hzk(this, bool1, bool2));
    }
  }
  
  /* Error */
  public void a(tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.AppointmentNotify paramAppointmentNotify)
  {
    // Byte code:
    //   0: ldc_w 558
    //   3: iconst_2
    //   4: anewarray 4	java/lang/Object
    //   7: dup
    //   8: iconst_0
    //   9: aload_0
    //   10: getfield 67	com/tencent/mobileqq/dating/DateEventManager:g	I
    //   13: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16: aastore
    //   17: dup
    //   18: iconst_1
    //   19: aload_1
    //   20: aastore
    //   21: invokestatic 182	com/tencent/mobileqq/dating/DatingUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: aload_1
    //   25: ifnonnull +4 -> 29
    //   28: return
    //   29: aload_0
    //   30: getfield 436	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_Boolean	Z
    //   33: ifne +7 -> 40
    //   36: aload_0
    //   37: invokespecial 559	com/tencent/mobileqq/dating/DateEventManager:b	()V
    //   40: aconst_null
    //   41: astore 8
    //   43: aconst_null
    //   44: astore 7
    //   46: aload_1
    //   47: getfield 565	tencent/im/s2c/msgtype0x210/submsgtype0x27/SubMsgType0x27$AppointmentNotify:bytes_event_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   50: invokevirtual 570	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   53: ifeq +43 -> 96
    //   56: aload_1
    //   57: getfield 565	tencent/im/s2c/msgtype0x210/submsgtype0x27/SubMsgType0x27$AppointmentNotify:bytes_event_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   60: invokevirtual 573	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   63: invokevirtual 579	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   66: astore 9
    //   68: aload 9
    //   70: ifnull +522 -> 592
    //   73: aload 9
    //   75: arraylength
    //   76: ifle +516 -> 592
    //   79: new 581	appoint/define/appoint_define$DateEvent
    //   82: dup
    //   83: invokespecial 582	appoint/define/appoint_define$DateEvent:<init>	()V
    //   86: astore 7
    //   88: aload 7
    //   90: aload 9
    //   92: invokevirtual 586	appoint/define/appoint_define$DateEvent:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   95: pop
    //   96: aload 7
    //   98: ifnonnull +51 -> 149
    //   101: ldc_w 558
    //   104: iconst_2
    //   105: anewarray 4	java/lang/Object
    //   108: dup
    //   109: iconst_0
    //   110: ldc_w 588
    //   113: aastore
    //   114: dup
    //   115: iconst_1
    //   116: aload_1
    //   117: getfield 592	tencent/im/s2c/msgtype0x210/submsgtype0x27/SubMsgType0x27$AppointmentNotify:uint32_notifytype	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   120: invokevirtual 596	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   123: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   126: aastore
    //   127: invokestatic 203	com/tencent/mobileqq/dating/DatingUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   130: return
    //   131: astore 9
    //   133: aload 8
    //   135: astore 7
    //   137: aload 9
    //   139: astore 8
    //   141: aload 8
    //   143: invokevirtual 232	java/lang/Exception:printStackTrace	()V
    //   146: goto -50 -> 96
    //   149: aload 7
    //   151: getfield 599	appoint/define/appoint_define$DateEvent:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   154: invokevirtual 596	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   157: istore_2
    //   158: aload 7
    //   160: getfield 603	appoint/define/appoint_define$DateEvent:uint64_event_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   163: invokevirtual 607	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   166: lstore 5
    //   168: iload_2
    //   169: bipush 6
    //   171: if_icmpeq +7 -> 178
    //   174: iload_2
    //   175: ifne +145 -> 320
    //   178: iload_2
    //   179: bipush 6
    //   181: if_icmpne +108 -> 289
    //   184: aload 7
    //   186: getfield 610	appoint/define/appoint_define$DateEvent:uint64_cancel_event_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   189: invokevirtual 607	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   192: lstore_3
    //   193: aload_0
    //   194: lload_3
    //   195: invokespecial 612	com/tencent/mobileqq/dating/DateEventManager:a	(J)Lcom/tencent/mobileqq/data/DateEventMsg;
    //   198: astore_1
    //   199: aload_1
    //   200: ifnull +29 -> 229
    //   203: aload_1
    //   204: iconst_1
    //   205: putfield 615	com/tencent/mobileqq/data/DateEventMsg:bDeleted	B
    //   208: aload_1
    //   209: invokevirtual 183	com/tencent/mobileqq/data/DateEventMsg:getStatus	()I
    //   212: sipush 1000
    //   215: if_icmpne +80 -> 295
    //   218: aload_0
    //   219: getfield 44	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_ComTencentMobileqqDatingDatingManager	Lcom/tencent/mobileqq/dating/DatingManager;
    //   222: getfield 102	com/tencent/mobileqq/dating/DatingManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   225: aload_1
    //   226: invokevirtual 164	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   229: ldc_w 558
    //   232: iconst_3
    //   233: anewarray 4	java/lang/Object
    //   236: dup
    //   237: iconst_0
    //   238: ldc_w 617
    //   241: aastore
    //   242: dup
    //   243: iconst_1
    //   244: lload_3
    //   245: invokestatic 201	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   248: aastore
    //   249: dup
    //   250: iconst_2
    //   251: aload_1
    //   252: aastore
    //   253: invokestatic 182	com/tencent/mobileqq/dating/DatingUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   256: ldc_w 558
    //   259: iconst_3
    //   260: anewarray 4	java/lang/Object
    //   263: dup
    //   264: iconst_0
    //   265: iload_2
    //   266: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   269: aastore
    //   270: dup
    //   271: iconst_1
    //   272: lload 5
    //   274: invokestatic 201	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   277: aastore
    //   278: dup
    //   279: iconst_2
    //   280: lload_3
    //   281: invokestatic 201	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   284: aastore
    //   285: invokestatic 182	com/tencent/mobileqq/dating/DatingUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   288: return
    //   289: lload 5
    //   291: lstore_3
    //   292: goto -99 -> 193
    //   295: aload_1
    //   296: invokevirtual 183	com/tencent/mobileqq/data/DateEventMsg:getStatus	()I
    //   299: sipush 1003
    //   302: if_icmpeq -73 -> 229
    //   305: aload_0
    //   306: getfield 44	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_ComTencentMobileqqDatingDatingManager	Lcom/tencent/mobileqq/dating/DatingManager;
    //   309: getfield 102	com/tencent/mobileqq/dating/DatingManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   312: aload_1
    //   313: invokevirtual 189	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   316: pop
    //   317: goto -88 -> 229
    //   320: iload_2
    //   321: iconst_1
    //   322: if_icmplt +226 -> 548
    //   325: iload_2
    //   326: iconst_5
    //   327: if_icmpgt +221 -> 548
    //   330: aload_0
    //   331: lload 5
    //   333: invokespecial 612	com/tencent/mobileqq/dating/DateEventManager:a	(J)Lcom/tencent/mobileqq/data/DateEventMsg;
    //   336: astore_1
    //   337: aload_1
    //   338: ifnonnull +183 -> 521
    //   341: aload 7
    //   343: invokestatic 621	com/tencent/mobileqq/data/DateEventMsg:convertFrom	(Lappoint/define/appoint_define$DateEvent;)Lcom/tencent/mobileqq/data/DateEventMsg;
    //   346: astore_1
    //   347: aload_0
    //   348: aload_1
    //   349: invokespecial 623	com/tencent/mobileqq/dating/DateEventManager:a	(Lcom/tencent/mobileqq/data/DateEventMsg;)V
    //   352: aload_0
    //   353: getfield 44	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_ComTencentMobileqqDatingDatingManager	Lcom/tencent/mobileqq/dating/DatingManager;
    //   356: ifnull +233 -> 589
    //   359: aload_1
    //   360: ifnull +229 -> 589
    //   363: aload_1
    //   364: getfield 140	com/tencent/mobileqq/data/DateEventMsg:date_info	Lappoint/define/appoint_define$AppointInfo;
    //   367: ifnull +222 -> 589
    //   370: aload_1
    //   371: getfield 140	com/tencent/mobileqq/data/DateEventMsg:date_info	Lappoint/define/appoint_define$AppointInfo;
    //   374: getfield 629	appoint/define/appoint_define$AppointInfo:msg_appoint_id	Lappoint/define/appoint_define$AppointID;
    //   377: invokevirtual 632	appoint/define/appoint_define$AppointID:has	()Z
    //   380: ifeq +209 -> 589
    //   383: aload_1
    //   384: getfield 140	com/tencent/mobileqq/data/DateEventMsg:date_info	Lappoint/define/appoint_define$AppointInfo;
    //   387: getfield 629	appoint/define/appoint_define$AppointInfo:msg_appoint_id	Lappoint/define/appoint_define$AppointID;
    //   390: invokevirtual 635	appoint/define/appoint_define$AppointID:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   393: checkcast 631	appoint/define/appoint_define$AppointID
    //   396: invokestatic 638	com/tencent/mobileqq/dating/DatingUtil:a	(Lappoint/define/appoint_define$AppointID;)Ljava/lang/String;
    //   399: astore 7
    //   401: ldc_w 558
    //   404: iconst_2
    //   405: anewarray 4	java/lang/Object
    //   408: dup
    //   409: iconst_0
    //   410: iload_2
    //   411: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   414: aastore
    //   415: dup
    //   416: iconst_1
    //   417: aload 7
    //   419: aastore
    //   420: invokestatic 203	com/tencent/mobileqq/dating/DatingUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   423: aload_0
    //   424: getfield 44	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_ComTencentMobileqqDatingDatingManager	Lcom/tencent/mobileqq/dating/DatingManager;
    //   427: aload 7
    //   429: iconst_0
    //   430: invokevirtual 641	com/tencent/mobileqq/dating/DatingManager:a	(Ljava/lang/String;Z)Lcom/tencent/mobileqq/data/DatingInfo;
    //   433: astore 8
    //   435: aload 8
    //   437: ifnull +9 -> 446
    //   440: aload 8
    //   442: lconst_0
    //   443: putfield 644	com/tencent/mobileqq/data/DatingInfo:lastUpdateTime	J
    //   446: iload_2
    //   447: iconst_5
    //   448: if_icmpne +36 -> 484
    //   451: aload 7
    //   453: invokestatic 650	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   456: ifne +28 -> 484
    //   459: aload 7
    //   461: aload_0
    //   462: getfield 44	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_ComTencentMobileqqDatingDatingManager	Lcom/tencent/mobileqq/dating/DatingManager;
    //   465: invokevirtual 652	com/tencent/mobileqq/dating/DatingManager:d	()Ljava/lang/String;
    //   468: invokevirtual 655	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   471: ifeq +13 -> 484
    //   474: aload_0
    //   475: getfield 44	com/tencent/mobileqq/dating/DateEventManager:jdField_a_of_type_ComTencentMobileqqDatingDatingManager	Lcom/tencent/mobileqq/dating/DatingManager;
    //   478: ldc_w 657
    //   481: invokevirtual 660	com/tencent/mobileqq/dating/DatingManager:a	(Ljava/lang/String;)V
    //   484: aload_1
    //   485: ifnull +25 -> 510
    //   488: aload_1
    //   489: getfield 97	com/tencent/mobileqq/data/DateEventMsg:event_id	J
    //   492: aload_0
    //   493: getfield 417	com/tencent/mobileqq/dating/DateEventManager:b	J
    //   496: lconst_1
    //   497: ladd
    //   498: lcmp
    //   499: ifne +11 -> 510
    //   502: aload_0
    //   503: aload_1
    //   504: getfield 97	com/tencent/mobileqq/data/DateEventMsg:event_id	J
    //   507: putfield 417	com/tencent/mobileqq/dating/DateEventManager:b	J
    //   510: aload_0
    //   511: iconst_1
    //   512: aload_1
    //   513: invokespecial 534	com/tencent/mobileqq/dating/DateEventManager:a	(ZLcom/tencent/mobileqq/data/DateEventMsg;)V
    //   516: lconst_0
    //   517: lstore_3
    //   518: goto -262 -> 256
    //   521: ldc_w 558
    //   524: iconst_2
    //   525: anewarray 4	java/lang/Object
    //   528: dup
    //   529: iconst_0
    //   530: lload 5
    //   532: invokestatic 201	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   535: aastore
    //   536: dup
    //   537: iconst_1
    //   538: ldc_w 662
    //   541: aastore
    //   542: invokestatic 203	com/tencent/mobileqq/dating/DatingUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   545: goto -61 -> 484
    //   548: ldc_w 558
    //   551: iconst_3
    //   552: anewarray 4	java/lang/Object
    //   555: dup
    //   556: iconst_0
    //   557: ldc_w 664
    //   560: aastore
    //   561: dup
    //   562: iconst_1
    //   563: lload 5
    //   565: invokestatic 201	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   568: aastore
    //   569: dup
    //   570: iconst_2
    //   571: iload_2
    //   572: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   575: aastore
    //   576: invokestatic 203	com/tencent/mobileqq/dating/DatingUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   579: lconst_0
    //   580: lstore_3
    //   581: goto -325 -> 256
    //   584: astore 8
    //   586: goto -445 -> 141
    //   589: goto -105 -> 484
    //   592: aconst_null
    //   593: astore 7
    //   595: goto -499 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	598	0	this	DateEventManager
    //   0	598	1	paramAppointmentNotify	tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.AppointmentNotify
    //   157	415	2	k	int
    //   192	389	3	l1	long
    //   166	398	5	l2	long
    //   44	550	7	localObject1	Object
    //   41	400	8	localObject2	Object
    //   584	1	8	localException1	Exception
    //   66	25	9	arrayOfByte	byte[]
    //   131	7	9	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   56	68	131	java/lang/Exception
    //   73	88	131	java/lang/Exception
    //   88	96	584	java/lang/Exception
  }
  
  public void a(short paramShort)
  {
    if (!this.jdField_a_of_type_Boolean) {
      b();
    }
    DatingUtil.a("onGetUnreadFlag", new Object[] { Short.valueOf(paramShort), Integer.valueOf(this.g), Integer.valueOf(this.f) });
    if (paramShort == 1) {
      this.f = 0;
    }
    for (boolean bool = a();; bool = false)
    {
      if (!bool) {
        a(false, null);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean, List paramList, long paramLong1, long paramLong2, long paramLong3)
  {
    if (!this.jdField_a_of_type_Boolean) {
      b();
    }
    DatingUtil.a("onGetUnreadMsgList", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    if (paramBoolean)
    {
      if ((paramList != null) && (paramList.size() > 0)) {
        paramList = paramList.iterator();
      }
      while (paramList.hasNext())
      {
        ??? = (appoint_define.DateEvent)paramList.next();
        if (??? != null)
        {
          k = ((appoint_define.DateEvent)???).uint32_type.get();
          paramLong2 = ((appoint_define.DateEvent)???).uint64_event_id.get();
          label156:
          DateEventMsg localDateEventMsg;
          if ((k == 0) || (k == 6)) {
            if (k == 6)
            {
              paramLong1 = ((appoint_define.DateEvent)???).uint64_cancel_event_id.get();
              localDateEventMsg = a(paramLong1);
              if (localDateEventMsg != null)
              {
                localDateEventMsg.bDeleted = 1;
                if (localDateEventMsg.getStatus() != 1000) {
                  break label282;
                }
                this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localDateEventMsg);
              }
            }
          }
          for (;;)
          {
            synchronized (this.jdField_a_of_type_JavaUtilList)
            {
              this.jdField_a_of_type_JavaUtilList.remove(localDateEventMsg);
              if (paramLong2 > this.b) {
                this.b = paramLong2;
              }
              DatingUtil.a("onGetUnreadMsgList", new Object[] { Integer.valueOf(k), Long.valueOf(paramLong2), Long.valueOf(this.b) });
              break;
              paramLong1 = paramLong2;
              break label156;
              label282:
              if (localDateEventMsg.getStatus() == 1003) {
                continue;
              }
              this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localDateEventMsg);
            }
            if ((k >= 1) && (k <= 5)) {
              if (a(paramLong2) == null) {
                a(DateEventMsg.convertFrom((appoint_define.DateEvent)???));
              } else {
                DatingUtil.a("onGetUnreadMsgList", new Object[] { Long.valueOf(paramLong2), "same msg" });
              }
            }
          }
          this.b = paramLong3;
        }
      }
      if (this.b < paramLong3) {}
      for (int k = 1;; k = 0)
      {
        boolean bool = false;
        paramBoolean = bool;
        if (k != 0)
        {
          paramBoolean = bool;
          if (this.f < 5)
          {
            this.f += 1;
            paramBoolean = a();
          }
        }
        if (!paramBoolean)
        {
          this.b = paramLong3;
          DatingUtil.a("onGetUnreadMsgList", new Object[] { Integer.valueOf(this.f) });
          a(false, null);
        }
        return;
      }
    }
    DatingUtil.a("onGetUnreadMsgList", new Object[] { Integer.valueOf(this.f) });
    a(false, null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      paramMessage = (DatingHandler)this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(40);
      if (paramMessage != null)
      {
        paramMessage.b();
        return false;
      }
      DatingUtil.b("MSG_GET_MORE_EVENT_TIMEOUT", new Object[] { "dh is null", Long.valueOf(this.b) });
      return false;
    case 2: 
      c();
      return false;
    }
    a((DateEventMsg)paramMessage.obj, this.jdField_a_of_type_Long);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DateEventManager
 * JD-Core Version:    0.7.0.1
 */