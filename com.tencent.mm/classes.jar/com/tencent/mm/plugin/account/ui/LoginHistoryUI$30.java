package com.tencent.mm.plugin.account.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class LoginHistoryUI$30
  implements n.c
{
  LoginHistoryUI$30(LoginHistoryUI paramLoginHistoryUI) {}
  
  public final void a(l paraml)
  {
    if (paraml.size() == 0)
    {
      paraml.fq(7002, q.j.login_by_others);
      paraml.fq(7003, q.j.intro_create_account_qq);
      paraml.fq(7004, q.j.wechat_safe_center);
      if (!x.cqG()) {
        paraml.fq(7009, q.j.wechat_help_center);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.30
 * JD-Core Version:    0.7.0.1
 */