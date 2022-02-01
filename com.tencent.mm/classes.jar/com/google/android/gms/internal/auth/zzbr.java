package com.google.android.gms.internal.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum zzbr
{
  private final String zzho;
  
  static
  {
    AppMethodBeat.i(10772);
    zzfn = new zzbr("CLIENT_LOGIN_DISABLED", 0, "ClientLoginDisabled");
    zzfo = new zzbr("DEVICE_MANAGEMENT_REQUIRED", 1, "DeviceManagementRequiredOrSyncDisabled");
    zzfp = new zzbr("SOCKET_TIMEOUT", 2, "SocketTimeout");
    zzfq = new zzbr("SUCCESS", 3, "Ok");
    zzfr = new zzbr("UNKNOWN_ERROR", 4, "UNKNOWN_ERR");
    zzfs = new zzbr("NETWORK_ERROR", 5, "NetworkError");
    zzft = new zzbr("SERVICE_UNAVAILABLE", 6, "ServiceUnavailable");
    zzfu = new zzbr("INTNERNAL_ERROR", 7, "InternalError");
    zzfv = new zzbr("BAD_AUTHENTICATION", 8, "BadAuthentication");
    zzfw = new zzbr("EMPTY_CONSUMER_PKG_OR_SIG", 9, "EmptyConsumerPackageOrSig");
    zzfx = new zzbr("NEEDS_2F", 10, "InvalidSecondFactor");
    zzfy = new zzbr("NEEDS_POST_SIGN_IN_FLOW", 11, "PostSignInFlowRequired");
    zzfz = new zzbr("NEEDS_BROWSER", 12, "NeedsBrowser");
    zzga = new zzbr("UNKNOWN", 13, "Unknown");
    zzgb = new zzbr("NOT_VERIFIED", 14, "NotVerified");
    zzgc = new zzbr("TERMS_NOT_AGREED", 15, "TermsNotAgreed");
    zzgd = new zzbr("ACCOUNT_DISABLED", 16, "AccountDisabled");
    zzge = new zzbr("CAPTCHA", 17, "CaptchaRequired");
    zzgf = new zzbr("ACCOUNT_DELETED", 18, "AccountDeleted");
    zzgg = new zzbr("SERVICE_DISABLED", 19, "ServiceDisabled");
    zzgh = new zzbr("NEED_PERMISSION", 20, "NeedPermission");
    zzgi = new zzbr("NEED_REMOTE_CONSENT", 21, "NeedRemoteConsent");
    zzgj = new zzbr("INVALID_SCOPE", 22, "INVALID_SCOPE");
    zzgk = new zzbr("USER_CANCEL", 23, "UserCancel");
    zzgl = new zzbr("PERMISSION_DENIED", 24, "PermissionDenied");
    zzgm = new zzbr("INVALID_AUDIENCE", 25, "INVALID_AUDIENCE");
    zzgn = new zzbr("UNREGISTERED_ON_API_CONSOLE", 26, "UNREGISTERED_ON_API_CONSOLE");
    zzgo = new zzbr("THIRD_PARTY_DEVICE_MANAGEMENT_REQUIRED", 27, "ThirdPartyDeviceManagementRequired");
    zzgp = new zzbr("DM_INTERNAL_ERROR", 28, "DeviceManagementInternalError");
    zzgq = new zzbr("DM_SYNC_DISABLED", 29, "DeviceManagementSyncDisabled");
    zzgr = new zzbr("DM_ADMIN_BLOCKED", 30, "DeviceManagementAdminBlocked");
    zzgs = new zzbr("DM_ADMIN_PENDING_APPROVAL", 31, "DeviceManagementAdminPendingApproval");
    zzgt = new zzbr("DM_STALE_SYNC_REQUIRED", 32, "DeviceManagementStaleSyncRequired");
    zzgu = new zzbr("DM_DEACTIVATED", 33, "DeviceManagementDeactivated");
    zzgv = new zzbr("DM_SCREENLOCK_REQUIRED", 34, "DeviceManagementScreenlockRequired");
    zzgw = new zzbr("DM_REQUIRED", 35, "DeviceManagementRequired");
    zzgx = new zzbr("ALREADY_HAS_GMAIL", 36, "ALREADY_HAS_GMAIL");
    zzgy = new zzbr("BAD_PASSWORD", 37, "WeakPassword");
    zzgz = new zzbr("BAD_REQUEST", 38, "BadRequest");
    zzha = new zzbr("BAD_USERNAME", 39, "BadUsername");
    zzhb = new zzbr("DELETED_GMAIL", 40, "DeletedGmail");
    zzhc = new zzbr("EXISTING_USERNAME", 41, "ExistingUsername");
    zzhd = new zzbr("LOGIN_FAIL", 42, "LoginFail");
    zzhe = new zzbr("NOT_LOGGED_IN", 43, "NotLoggedIn");
    zzhf = new zzbr("NO_GMAIL", 44, "NoGmail");
    zzhg = new zzbr("REQUEST_DENIED", 45, "RequestDenied");
    zzhh = new zzbr("SERVER_ERROR", 46, "ServerError");
    zzhi = new zzbr("USERNAME_UNAVAILABLE", 47, "UsernameUnavailable");
    zzhj = new zzbr("GPLUS_OTHER", 48, "GPlusOther");
    zzhk = new zzbr("GPLUS_NICKNAME", 49, "GPlusNickname");
    zzhl = new zzbr("GPLUS_INVALID_CHAR", 50, "GPlusInvalidChar");
    zzhm = new zzbr("GPLUS_INTERSTITIAL", 51, "GPlusInterstitial");
    zzhn = new zzbr("GPLUS_PROFILE_ERROR", 52, "ProfileUpgradeError");
    zzhp = new zzbr[] { zzfn, zzfo, zzfp, zzfq, zzfr, zzfs, zzft, zzfu, zzfv, zzfw, zzfx, zzfy, zzfz, zzga, zzgb, zzgc, zzgd, zzge, zzgf, zzgg, zzgh, zzgi, zzgj, zzgk, zzgl, zzgm, zzgn, zzgo, zzgp, zzgq, zzgr, zzgs, zzgt, zzgu, zzgv, zzgw, zzgx, zzgy, zzgz, zzha, zzhb, zzhc, zzhd, zzhe, zzhf, zzhg, zzhh, zzhi, zzhj, zzhk, zzhl, zzhm, zzhn };
    AppMethodBeat.o(10772);
  }
  
  private zzbr(String paramString)
  {
    this.zzho = paramString;
  }
  
  public static boolean zzd(zzbr paramzzbr)
  {
    AppMethodBeat.i(10771);
    if ((zzfv.equals(paramzzbr)) || (zzge.equals(paramzzbr)) || (zzgh.equals(paramzzbr)) || (zzgi.equals(paramzzbr)) || (zzfz.equals(paramzzbr)) || (zzgk.equals(paramzzbr)) || (zzfo.equals(paramzzbr)) || (zzgp.equals(paramzzbr)) || (zzgq.equals(paramzzbr)) || (zzgr.equals(paramzzbr)) || (zzgs.equals(paramzzbr)) || (zzgt.equals(paramzzbr)) || (zzgu.equals(paramzzbr)) || (zzgw.equals(paramzzbr)) || (zzgo.equals(paramzzbr)) || (zzgv.equals(paramzzbr)))
    {
      AppMethodBeat.o(10771);
      return true;
    }
    AppMethodBeat.o(10771);
    return false;
  }
  
  public static final zzbr zzh(String paramString)
  {
    AppMethodBeat.i(10770);
    Object localObject = null;
    zzbr[] arrayOfzzbr = values();
    int j = arrayOfzzbr.length;
    int i = 0;
    if (i < j)
    {
      zzbr localzzbr = arrayOfzzbr[i];
      if (!localzzbr.zzho.equals(paramString)) {
        break label60;
      }
      localObject = localzzbr;
    }
    label60:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(10770);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzbr
 * JD-Core Version:    0.7.0.1
 */