package com.tencent.mm.plugin.appbrand.jsapi.auth.entity;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.dialog.k.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$WxaUserInfoEventListener;", "", "onCreateUserActionUpdate", "", "action", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$WxaUserInfoEventListener$CreateUserAction;", "onItemListChanged", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "updateAddNewAvatarEntry", "isBan", "", "reachMaxCount", "limitWording", "", "avatarWording", "goAddUserPage", "Lkotlin/Function2;", "Landroid/app/Activity;", "Lkotlin/ParameterName;", "name", "activity", "appId", "CreateUserAction", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b$c
{
  public abstract void a(a parama);
  
  public abstract void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, m<? super Activity, ? super String, ah> paramm);
  
  public abstract void di(List<k.a> paramList);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$WxaUserInfoEventListener$CreateUserAction;", "", "reportAction", "", "(Ljava/lang/String;II)V", "getReportAction", "()I", "NO_ACTION", "CREATE_FAIL", "CREATE_SUCCESS", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    public final int rHu;
    
    static
    {
      AppMethodBeat.i(327005);
      rHv = new a("NO_ACTION", 0, 1);
      rHw = new a("CREATE_FAIL", 1, 2);
      rHx = new a("CREATE_SUCCESS", 2, 3);
      rHy = new a[] { rHv, rHw, rHx };
      AppMethodBeat.o(327005);
    }
    
    private a(int paramInt)
    {
      this.rHu = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b.c
 * JD-Core Version:    0.7.0.1
 */