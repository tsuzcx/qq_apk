package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import cooperation.qwallet.plugin.QWalletHelper;

public class CorpReq
  extends BaseReq
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public String b;
  public String c;
  public int d;
  public int e;
  public int f;
  
  public void a()
  {
    switch (this.d)
    {
    default: 
      return;
    case 1: 
      b();
      return;
    case 2: 
      c();
      return;
    }
    d();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle.putInt("_qwallet_ipc_CorpReq_corpReqType", this.d);
    paramBundle.putInt("_qwallet_ipc_CorpReq_faceType", this.e);
    paramBundle.putString("_qwallet_ipc_CorpReq_uin", this.b);
    paramBundle.putInt("_qwallet_ipc_CorpReq_subType", this.f);
    paramBundle.putString("_qwallet_ipc_CorpReq_groupId", this.c);
  }
  
  public void b()
  {
    CorpResp localCorpResp = new CorpResp();
    localCorpResp.jdField_a_of_type_Int = this.d;
    Object localObject = QWalletHelper.a();
    if (localObject != null) {
      localCorpResp.b = ((QQAppInterface)localObject).a(this.e, this.b, this.f);
    }
    localObject = new Bundle();
    localCorpResp.a((Bundle)localObject);
    a((Bundle)localObject);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.d = paramBundle.getInt("_qwallet_ipc_CorpReq_corpReqType");
    this.e = paramBundle.getInt("_qwallet_ipc_CorpReq_faceType");
    this.b = paramBundle.getString("_qwallet_ipc_CorpReq_uin");
    this.f = paramBundle.getInt("_qwallet_ipc_CorpReq_subType");
    this.c = paramBundle.getString("_qwallet_ipc_CorpReq_groupId");
  }
  
  public void c()
  {
    CorpResp localCorpResp = new CorpResp();
    localCorpResp.jdField_a_of_type_Int = this.d;
    Object localObject = QWalletHelper.a();
    if (localObject != null) {
      localCorpResp.jdField_a_of_type_Boolean = ((FriendsManager)((QQAppInterface)localObject).getManager(49)).b(this.b);
    }
    localObject = new Bundle();
    localCorpResp.a((Bundle)localObject);
    a((Bundle)localObject);
  }
  
  public void d()
  {
    CorpResp localCorpResp = new CorpResp();
    localCorpResp.jdField_a_of_type_Int = this.d;
    Object localObject1 = QWalletHelper.a();
    Object localObject3;
    Object localObject2;
    if (localObject1 != null)
    {
      if (TextUtils.isEmpty(this.c)) {
        break label257;
      }
      localObject3 = (FriendsManager)((QQAppInterface)localObject1).getManager(49);
      localObject2 = (TroopManager)((QQAppInterface)localObject1).getManager(50);
      if ((TextUtils.isEmpty(this.c)) || (TextUtils.isEmpty(this.b)))
      {
        localCorpResp.c = this.b;
        return;
      }
      localObject3 = ((FriendsManager)localObject3).c(this.b);
      localObject2 = ((TroopManager)localObject2).a(this.c, this.b);
      if ((localObject3 == null) || (TextUtils.isEmpty(((Friends)localObject3).remark))) {
        break label169;
      }
      localObject1 = ((Friends)localObject3).remark;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.b;
      }
      label257:
      for (localCorpResp.c = ((String)localObject2);; localCorpResp.c = ContactUtils.j((QQAppInterface)localObject1, this.b))
      {
        localObject1 = new Bundle();
        localCorpResp.a((Bundle)localObject1);
        a((Bundle)localObject1);
        return;
        label169:
        if ((localObject2 != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject2).troopnick)))
        {
          localObject1 = ((TroopMemberInfo)localObject2).troopnick;
          break;
        }
        if (localObject3 != null)
        {
          localObject1 = ((Friends)localObject3).name;
          break;
        }
        if (localObject2 == null) {
          break label272;
        }
        if (this.b.equals(((QQAppInterface)localObject1).a()))
        {
          localObject1 = ((TroopMemberInfo)localObject2).friendnick;
          break;
        }
        if (!TextUtils.isEmpty(((TroopMemberInfo)localObject2).autoremark))
        {
          localObject1 = ((TroopMemberInfo)localObject2).autoremark;
          break;
        }
        localObject1 = ((TroopMemberInfo)localObject2).friendnick;
        break;
      }
      label272:
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.CorpReq
 * JD-Core Version:    0.7.0.1
 */