package com.google.android.gms.auth.api.signin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.zzi;
import com.google.android.gms.auth.api.signin.internal.zzq;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class GoogleSignIn
{
  public static GoogleSignInAccount getAccountForExtension(Context paramContext, GoogleSignInOptionsExtension paramGoogleSignInOptionsExtension)
  {
    AppMethodBeat.i(88272);
    Preconditions.checkNotNull(paramContext, "please provide a valid Context object");
    Preconditions.checkNotNull(paramGoogleSignInOptionsExtension, "please provide valid GoogleSignInOptionsExtension");
    GoogleSignInAccount localGoogleSignInAccount = getLastSignedInAccount(paramContext);
    paramContext = localGoogleSignInAccount;
    if (localGoogleSignInAccount == null) {
      paramContext = GoogleSignInAccount.createDefault();
    }
    paramContext = paramContext.requestExtraScopes(zzd(paramGoogleSignInOptionsExtension.getImpliedScopes()));
    AppMethodBeat.o(88272);
    return paramContext;
  }
  
  public static GoogleSignInAccount getAccountForScopes(Context paramContext, Scope paramScope, Scope... paramVarArgs)
  {
    AppMethodBeat.i(88271);
    Preconditions.checkNotNull(paramContext, "please provide a valid Context object");
    Preconditions.checkNotNull(paramScope, "please provide at least one valid scope");
    GoogleSignInAccount localGoogleSignInAccount = getLastSignedInAccount(paramContext);
    paramContext = localGoogleSignInAccount;
    if (localGoogleSignInAccount == null) {
      paramContext = GoogleSignInAccount.createDefault();
    }
    paramContext.requestExtraScopes(new Scope[] { paramScope });
    paramContext.requestExtraScopes(paramVarArgs);
    AppMethodBeat.o(88271);
    return paramContext;
  }
  
  public static GoogleSignInClient getClient(Activity paramActivity, GoogleSignInOptions paramGoogleSignInOptions)
  {
    AppMethodBeat.i(88268);
    paramActivity = new GoogleSignInClient(paramActivity, (GoogleSignInOptions)Preconditions.checkNotNull(paramGoogleSignInOptions));
    AppMethodBeat.o(88268);
    return paramActivity;
  }
  
  public static GoogleSignInClient getClient(Context paramContext, GoogleSignInOptions paramGoogleSignInOptions)
  {
    AppMethodBeat.i(88267);
    paramContext = new GoogleSignInClient(paramContext, (GoogleSignInOptions)Preconditions.checkNotNull(paramGoogleSignInOptions));
    AppMethodBeat.o(88267);
    return paramContext;
  }
  
  public static GoogleSignInAccount getLastSignedInAccount(Context paramContext)
  {
    AppMethodBeat.i(88270);
    paramContext = zzq.zze(paramContext).zzo();
    AppMethodBeat.o(88270);
    return paramContext;
  }
  
  public static Task<GoogleSignInAccount> getSignedInAccountFromIntent(Intent paramIntent)
  {
    AppMethodBeat.i(88269);
    paramIntent = zzi.getSignInResultFromIntent(paramIntent);
    if (paramIntent == null)
    {
      paramIntent = Tasks.forException(ApiExceptionUtil.fromStatus(Status.RESULT_INTERNAL_ERROR));
      AppMethodBeat.o(88269);
      return paramIntent;
    }
    if ((!paramIntent.getStatus().isSuccess()) || (paramIntent.getSignInAccount() == null))
    {
      paramIntent = Tasks.forException(ApiExceptionUtil.fromStatus(paramIntent.getStatus()));
      AppMethodBeat.o(88269);
      return paramIntent;
    }
    paramIntent = Tasks.forResult(paramIntent.getSignInAccount());
    AppMethodBeat.o(88269);
    return paramIntent;
  }
  
  public static boolean hasPermissions(GoogleSignInAccount paramGoogleSignInAccount, GoogleSignInOptionsExtension paramGoogleSignInOptionsExtension)
  {
    AppMethodBeat.i(88273);
    Preconditions.checkNotNull(paramGoogleSignInOptionsExtension, "Please provide a non-null GoogleSignInOptionsExtension");
    boolean bool = hasPermissions(paramGoogleSignInAccount, zzd(paramGoogleSignInOptionsExtension.getImpliedScopes()));
    AppMethodBeat.o(88273);
    return bool;
  }
  
  public static boolean hasPermissions(GoogleSignInAccount paramGoogleSignInAccount, Scope... paramVarArgs)
  {
    AppMethodBeat.i(88274);
    if (paramGoogleSignInAccount == null)
    {
      AppMethodBeat.o(88274);
      return false;
    }
    HashSet localHashSet = new HashSet();
    Collections.addAll(localHashSet, paramVarArgs);
    boolean bool = paramGoogleSignInAccount.getGrantedScopes().containsAll(localHashSet);
    AppMethodBeat.o(88274);
    return bool;
  }
  
  public static void requestPermissions(Activity paramActivity, int paramInt, GoogleSignInAccount paramGoogleSignInAccount, GoogleSignInOptionsExtension paramGoogleSignInOptionsExtension)
  {
    AppMethodBeat.i(88275);
    Preconditions.checkNotNull(paramActivity, "Please provide a non-null Activity");
    Preconditions.checkNotNull(paramGoogleSignInOptionsExtension, "Please provide a non-null GoogleSignInOptionsExtension");
    requestPermissions(paramActivity, paramInt, paramGoogleSignInAccount, zzd(paramGoogleSignInOptionsExtension.getImpliedScopes()));
    AppMethodBeat.o(88275);
  }
  
  public static void requestPermissions(Activity paramActivity, int paramInt, GoogleSignInAccount paramGoogleSignInAccount, Scope... paramVarArgs)
  {
    AppMethodBeat.i(88277);
    Preconditions.checkNotNull(paramActivity, "Please provide a non-null Activity");
    Preconditions.checkNotNull(paramVarArgs, "Please provide at least one scope");
    paramActivity.startActivityForResult(zzd(paramActivity, paramGoogleSignInAccount, paramVarArgs), paramInt);
    AppMethodBeat.o(88277);
  }
  
  public static void requestPermissions(Fragment paramFragment, int paramInt, GoogleSignInAccount paramGoogleSignInAccount, GoogleSignInOptionsExtension paramGoogleSignInOptionsExtension)
  {
    AppMethodBeat.i(88276);
    Preconditions.checkNotNull(paramFragment, "Please provide a non-null Fragment");
    Preconditions.checkNotNull(paramGoogleSignInOptionsExtension, "Please provide a non-null GoogleSignInOptionsExtension");
    requestPermissions(paramFragment, paramInt, paramGoogleSignInAccount, zzd(paramGoogleSignInOptionsExtension.getImpliedScopes()));
    AppMethodBeat.o(88276);
  }
  
  public static void requestPermissions(Fragment paramFragment, int paramInt, GoogleSignInAccount paramGoogleSignInAccount, Scope... paramVarArgs)
  {
    AppMethodBeat.i(88278);
    Preconditions.checkNotNull(paramFragment, "Please provide a non-null Fragment");
    Preconditions.checkNotNull(paramVarArgs, "Please provide at least one scope");
    paramFragment.startActivityForResult(zzd(paramFragment.getActivity(), paramGoogleSignInAccount, paramVarArgs), paramInt);
    AppMethodBeat.o(88278);
  }
  
  private static Intent zzd(Activity paramActivity, GoogleSignInAccount paramGoogleSignInAccount, Scope... paramVarArgs)
  {
    AppMethodBeat.i(88279);
    GoogleSignInOptions.Builder localBuilder = new GoogleSignInOptions.Builder();
    if (paramVarArgs.length > 0) {
      localBuilder.requestScopes(paramVarArgs[0], paramVarArgs);
    }
    if ((paramGoogleSignInAccount != null) && (!TextUtils.isEmpty(paramGoogleSignInAccount.getEmail()))) {
      localBuilder.setAccountName(paramGoogleSignInAccount.getEmail());
    }
    paramActivity = new GoogleSignInClient(paramActivity, localBuilder.build()).getSignInIntent();
    AppMethodBeat.o(88279);
    return paramActivity;
  }
  
  private static Scope[] zzd(List<Scope> paramList)
  {
    AppMethodBeat.i(88280);
    if (paramList == null)
    {
      AppMethodBeat.o(88280);
      return new Scope[0];
    }
    paramList = (Scope[])paramList.toArray(new Scope[paramList.size()]);
    AppMethodBeat.o(88280);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignIn
 * JD-Core Version:    0.7.0.1
 */