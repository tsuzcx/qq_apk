import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.StrangerManageActivity;
import com.tencent.mobileqq.activity.StrangerManageActivity.StrangeManagerListAdapter;
import com.tencent.mobileqq.app.StrangerObserver;
import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4.DelResult;

public class fci
  extends StrangerObserver
{
  public fci(StrangerManageActivity paramStrangerManageActivity) {}
  
  public void a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Stranger localStranger1 = (Stranger)paramList.next();
      Iterator localIterator = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Stranger localStranger2 = (Stranger)localIterator.next();
        if (TextUtils.equals(localStranger2.uin, localStranger1.uin)) {
          Stranger.copyInfo(localStranger1, localStranger2);
        }
      }
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityStrangerManageActivity$StrangeManagerListAdapter.notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean, PBRepeatMessageField paramPBRepeatMessageField)
  {
    this.a.c();
    int i;
    int j;
    if (paramBoolean)
    {
      if (paramPBRepeatMessageField == null) {
        break label404;
      }
      paramPBRepeatMessageField = paramPBRepeatMessageField.get().iterator();
      i = 0;
      int k;
      for (j = 0; paramPBRepeatMessageField.hasNext(); j = k)
      {
        oidb_0x5d4.DelResult localDelResult = (oidb_0x5d4.DelResult)paramPBRepeatMessageField.next();
        k = this.a.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        int m = i;
        i = j;
        j = m;
        if (k >= 0)
        {
          Stranger localStranger = (Stranger)this.a.jdField_a_of_type_JavaUtilArrayList.get(k);
          m = j;
          int n = i;
          if (localStranger.uin.equals(String.valueOf(localDelResult.uin.get())))
          {
            if (localDelResult.res.get() != 0) {
              break label174;
            }
            m = j + 1;
            this.a.jdField_a_of_type_JavaUtilArrayList.remove(localStranger);
            n = i;
          }
          for (;;)
          {
            k -= 1;
            j = m;
            i = n;
            break;
            label174:
            n = i + 1;
            m = j;
          }
        }
        k = i;
        i = j;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityStrangerManageActivity$StrangeManagerListAdapter.notifyDataSetChanged();
    }
    for (;;)
    {
      if (j > 0)
      {
        if (i > 0)
        {
          QQToast.a(this.a, "" + j + this.a.getString(2131369122), 0).b(this.a.getTitleBarHeight());
          return;
        }
        QQToast.a(this.a, this.a.getString(2131369125), 0).b(this.a.getTitleBarHeight());
        return;
      }
      QQToast.a(this.a, this.a.getString(2131369124), 0).b(this.a.getTitleBarHeight());
      this.a.b(false);
      return;
      if (NetworkUtil.e(this.a))
      {
        QQToast.a(this.a, this.a.getString(2131369125), 0).b(this.a.getTitleBarHeight());
        return;
      }
      QQToast.a(this.a, this.a.getString(2131365943), 0).b(this.a.getTitleBarHeight());
      return;
      label404:
      i = 0;
      j = 0;
    }
  }
  
  /* Error */
  public void a(boolean paramBoolean, List paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 10	fci:a	Lcom/tencent/mobileqq/activity/StrangerManageActivity;
    //   4: invokestatic 164	com/tencent/mobileqq/activity/StrangerManageActivity:a	(Lcom/tencent/mobileqq/activity/StrangerManageActivity;)Z
    //   7: istore 4
    //   9: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +11 -> 23
    //   15: ldc 171
    //   17: iconst_2
    //   18: ldc 173
    //   20: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: iload_1
    //   24: ifeq +267 -> 291
    //   27: aload_2
    //   28: ifnull +53 -> 81
    //   31: aload_0
    //   32: getfield 10	fci:a	Lcom/tencent/mobileqq/activity/StrangerManageActivity;
    //   35: getfield 41	com/tencent/mobileqq/activity/StrangerManageActivity:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   38: invokevirtual 180	java/util/ArrayList:clear	()V
    //   41: aload_0
    //   42: getfield 10	fci:a	Lcom/tencent/mobileqq/activity/StrangerManageActivity;
    //   45: getfield 41	com/tencent/mobileqq/activity/StrangerManageActivity:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   48: aload_2
    //   49: invokevirtual 184	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   52: pop
    //   53: aload_0
    //   54: getfield 10	fci:a	Lcom/tencent/mobileqq/activity/StrangerManageActivity;
    //   57: getfield 186	com/tencent/mobileqq/activity/StrangerManageActivity:c	Ljava/lang/String;
    //   60: aload_0
    //   61: getfield 10	fci:a	Lcom/tencent/mobileqq/activity/StrangerManageActivity;
    //   64: getfield 41	com/tencent/mobileqq/activity/StrangerManageActivity:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   67: invokestatic 189	com/tencent/mobileqq/activity/StrangerManageActivity:a	(Ljava/lang/String;Ljava/util/List;)Ljava/util/List;
    //   70: pop
    //   71: aload_0
    //   72: getfield 10	fci:a	Lcom/tencent/mobileqq/activity/StrangerManageActivity;
    //   75: getfield 61	com/tencent/mobileqq/activity/StrangerManageActivity:jdField_a_of_type_ComTencentMobileqqActivityStrangerManageActivity$StrangeManagerListAdapter	Lcom/tencent/mobileqq/activity/StrangerManageActivity$StrangeManagerListAdapter;
    //   78: invokevirtual 66	com/tencent/mobileqq/activity/StrangerManageActivity$StrangeManagerListAdapter:notifyDataSetChanged	()V
    //   81: aload_0
    //   82: getfield 10	fci:a	Lcom/tencent/mobileqq/activity/StrangerManageActivity;
    //   85: getfield 186	com/tencent/mobileqq/activity/StrangerManageActivity:c	Ljava/lang/String;
    //   88: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   91: ifne +105 -> 196
    //   94: aload_0
    //   95: getfield 10	fci:a	Lcom/tencent/mobileqq/activity/StrangerManageActivity;
    //   98: invokestatic 194	com/tencent/mobileqq/activity/StrangerManageActivity:b	(Lcom/tencent/mobileqq/activity/StrangerManageActivity;)Z
    //   101: ifne +95 -> 196
    //   104: aload_0
    //   105: getfield 10	fci:a	Lcom/tencent/mobileqq/activity/StrangerManageActivity;
    //   108: iconst_1
    //   109: invokestatic 197	com/tencent/mobileqq/activity/StrangerManageActivity:a	(Lcom/tencent/mobileqq/activity/StrangerManageActivity;Z)Z
    //   112: pop
    //   113: aload_0
    //   114: getfield 10	fci:a	Lcom/tencent/mobileqq/activity/StrangerManageActivity;
    //   117: getfield 41	com/tencent/mobileqq/activity/StrangerManageActivity:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   120: invokevirtual 44	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   123: astore_2
    //   124: aload_2
    //   125: invokeinterface 30 1 0
    //   130: ifeq +231 -> 361
    //   133: aload_2
    //   134: invokeinterface 34 1 0
    //   139: checkcast 36	com/tencent/mobileqq/data/Stranger
    //   142: astore 5
    //   144: aload_0
    //   145: getfield 10	fci:a	Lcom/tencent/mobileqq/activity/StrangerManageActivity;
    //   148: getfield 186	com/tencent/mobileqq/activity/StrangerManageActivity:c	Ljava/lang/String;
    //   151: aload 5
    //   153: getfield 48	com/tencent/mobileqq/data/Stranger:uin	Ljava/lang/String;
    //   156: invokestatic 54	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   159: ifeq -35 -> 124
    //   162: iconst_1
    //   163: istore_3
    //   164: iload_3
    //   165: ifne +31 -> 196
    //   168: aload_0
    //   169: getfield 10	fci:a	Lcom/tencent/mobileqq/activity/StrangerManageActivity;
    //   172: aload_0
    //   173: getfield 10	fci:a	Lcom/tencent/mobileqq/activity/StrangerManageActivity;
    //   176: ldc 198
    //   178: invokevirtual 130	com/tencent/mobileqq/activity/StrangerManageActivity:getString	(I)Ljava/lang/String;
    //   181: iconst_0
    //   182: invokestatic 139	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   185: aload_0
    //   186: getfield 10	fci:a	Lcom/tencent/mobileqq/activity/StrangerManageActivity;
    //   189: invokevirtual 142	com/tencent/mobileqq/activity/StrangerManageActivity:getTitleBarHeight	()I
    //   192: invokevirtual 146	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   195: pop
    //   196: aload_0
    //   197: getfield 10	fci:a	Lcom/tencent/mobileqq/activity/StrangerManageActivity;
    //   200: invokestatic 201	com/tencent/mobileqq/activity/StrangerManageActivity:a	(Lcom/tencent/mobileqq/activity/StrangerManageActivity;)Landroid/widget/TextView;
    //   203: astore_2
    //   204: aload_0
    //   205: getfield 10	fci:a	Lcom/tencent/mobileqq/activity/StrangerManageActivity;
    //   208: getfield 41	com/tencent/mobileqq/activity/StrangerManageActivity:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   211: invokevirtual 202	java/util/ArrayList:isEmpty	()Z
    //   214: ifne +72 -> 286
    //   217: iconst_1
    //   218: istore_1
    //   219: aload_2
    //   220: iload_1
    //   221: invokevirtual 207	android/widget/TextView:setEnabled	(Z)V
    //   224: aload_0
    //   225: getfield 10	fci:a	Lcom/tencent/mobileqq/activity/StrangerManageActivity;
    //   228: getfield 210	com/tencent/mobileqq/activity/StrangerManageActivity:jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader	Lcom/tencent/mobileqq/widget/PullRefreshHeader;
    //   231: iconst_0
    //   232: invokevirtual 215	com/tencent/mobileqq/widget/PullRefreshHeader:a	(I)V
    //   235: aload_0
    //   236: getfield 10	fci:a	Lcom/tencent/mobileqq/activity/StrangerManageActivity;
    //   239: getfield 218	com/tencent/mobileqq/activity/StrangerManageActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   242: iconst_1
    //   243: ldc2_w 219
    //   246: invokevirtual 226	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   249: pop
    //   250: aload_0
    //   251: getfield 10	fci:a	Lcom/tencent/mobileqq/activity/StrangerManageActivity;
    //   254: iconst_0
    //   255: putfield 229	com/tencent/mobileqq/activity/StrangerManageActivity:b	Z
    //   258: return
    //   259: astore_2
    //   260: aload_0
    //   261: getfield 10	fci:a	Lcom/tencent/mobileqq/activity/StrangerManageActivity;
    //   264: getfield 61	com/tencent/mobileqq/activity/StrangerManageActivity:jdField_a_of_type_ComTencentMobileqqActivityStrangerManageActivity$StrangeManagerListAdapter	Lcom/tencent/mobileqq/activity/StrangerManageActivity$StrangeManagerListAdapter;
    //   267: invokevirtual 66	com/tencent/mobileqq/activity/StrangerManageActivity$StrangeManagerListAdapter:notifyDataSetChanged	()V
    //   270: goto -189 -> 81
    //   273: astore_2
    //   274: aload_0
    //   275: getfield 10	fci:a	Lcom/tencent/mobileqq/activity/StrangerManageActivity;
    //   278: getfield 61	com/tencent/mobileqq/activity/StrangerManageActivity:jdField_a_of_type_ComTencentMobileqqActivityStrangerManageActivity$StrangeManagerListAdapter	Lcom/tencent/mobileqq/activity/StrangerManageActivity$StrangeManagerListAdapter;
    //   281: invokevirtual 66	com/tencent/mobileqq/activity/StrangerManageActivity$StrangeManagerListAdapter:notifyDataSetChanged	()V
    //   284: aload_2
    //   285: athrow
    //   286: iconst_0
    //   287: istore_1
    //   288: goto -69 -> 219
    //   291: iload 4
    //   293: ifeq +54 -> 347
    //   296: aload_0
    //   297: getfield 10	fci:a	Lcom/tencent/mobileqq/activity/StrangerManageActivity;
    //   300: invokestatic 157	com/tencent/mobileqq/utils/NetworkUtil:e	(Landroid/content/Context;)Z
    //   303: ifne +44 -> 347
    //   306: aload_0
    //   307: getfield 10	fci:a	Lcom/tencent/mobileqq/activity/StrangerManageActivity;
    //   310: getfield 41	com/tencent/mobileqq/activity/StrangerManageActivity:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   313: invokevirtual 202	java/util/ArrayList:isEmpty	()Z
    //   316: ifeq +31 -> 347
    //   319: aload_0
    //   320: getfield 10	fci:a	Lcom/tencent/mobileqq/activity/StrangerManageActivity;
    //   323: aload_0
    //   324: getfield 10	fci:a	Lcom/tencent/mobileqq/activity/StrangerManageActivity;
    //   327: ldc 158
    //   329: invokevirtual 130	com/tencent/mobileqq/activity/StrangerManageActivity:getString	(I)Ljava/lang/String;
    //   332: iconst_0
    //   333: invokestatic 139	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   336: aload_0
    //   337: getfield 10	fci:a	Lcom/tencent/mobileqq/activity/StrangerManageActivity;
    //   340: invokevirtual 142	com/tencent/mobileqq/activity/StrangerManageActivity:getTitleBarHeight	()I
    //   343: invokevirtual 146	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   346: pop
    //   347: aload_0
    //   348: getfield 10	fci:a	Lcom/tencent/mobileqq/activity/StrangerManageActivity;
    //   351: getfield 210	com/tencent/mobileqq/activity/StrangerManageActivity:jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader	Lcom/tencent/mobileqq/widget/PullRefreshHeader;
    //   354: iconst_1
    //   355: invokevirtual 215	com/tencent/mobileqq/widget/PullRefreshHeader:a	(I)V
    //   358: goto -123 -> 235
    //   361: iconst_0
    //   362: istore_3
    //   363: goto -199 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	366	0	this	fci
    //   0	366	1	paramBoolean	boolean
    //   0	366	2	paramList	List
    //   163	200	3	i	int
    //   7	285	4	bool	boolean
    //   142	10	5	localStranger	Stranger
    // Exception table:
    //   from	to	target	type
    //   53	71	259	java/lang/Exception
    //   53	71	273	finally
  }
  
  public void b(List paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Long localLong = (Long)paramList.next();
        this.a.jdField_a_of_type_JavaUtilHashSet.remove(String.valueOf(localLong));
      }
    }
  }
  
  public void b(boolean paramBoolean, List paramList)
  {
    if (paramBoolean)
    {
      if (paramList != null)
      {
        this.a.jdField_a_of_type_JavaUtilArrayList.clear();
        this.a.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
        StrangerManageActivity.a(this.a.c, this.a.jdField_a_of_type_JavaUtilArrayList);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityStrangerManageActivity$StrangeManagerListAdapter.notifyDataSetChanged();
      }
      paramList = StrangerManageActivity.b(this.a);
      if (this.a.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        break label87;
      }
    }
    label87:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramList.setEnabled(paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fci
 * JD-Core Version:    0.7.0.1
 */