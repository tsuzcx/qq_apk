package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.TroopObserver;

public class TroopPrivilegeActivity$PrivilegeTroopObserver
  extends TroopObserver
{
  public TroopPrivilegeActivity$PrivilegeTroopObserver(TroopPrivilegeActivity paramTroopPrivilegeActivity) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    int j = 1;
    TroopPrivilegeActivity.PrivilegeAdapter localPrivilegeAdapter;
    String str;
    if (paramBoolean1)
    {
      localPrivilegeAdapter = this.a.a;
      str = this.a.getString(2131363507);
      if (!paramBoolean4) {
        break label92;
      }
      i = 1;
      localPrivilegeAdapter.a(str, i);
      localPrivilegeAdapter = this.a.a;
      str = this.a.getString(2131363506);
      if (!paramBoolean3) {
        break label98;
      }
    }
    label92:
    label98:
    for (int i = j;; i = 2)
    {
      localPrivilegeAdapter.a(str, i);
      this.a.a.notifyDataSetChanged();
      return;
      i = 2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopPrivilegeActivity.PrivilegeTroopObserver
 * JD-Core Version:    0.7.0.1
 */