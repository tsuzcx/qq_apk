package com.facebook.share.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.DialogPresenter.ParameterProvider;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FacebookDialogBase.ModeHandler;
import com.facebook.internal.FragmentWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class LikeDialog
  extends FacebookDialogBase<LikeContent, Result>
{
  private static final int DEFAULT_REQUEST_CODE;
  private static final String TAG = "LikeDialog";
  
  static
  {
    AppMethodBeat.i(8142);
    DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.Like.toRequestCode();
    AppMethodBeat.o(8142);
  }
  
  @Deprecated
  public LikeDialog(Activity paramActivity)
  {
    super(paramActivity, DEFAULT_REQUEST_CODE);
  }
  
  @Deprecated
  public LikeDialog(android.app.Fragment paramFragment)
  {
    this(new FragmentWrapper(paramFragment));
    AppMethodBeat.i(8134);
    AppMethodBeat.o(8134);
  }
  
  @Deprecated
  public LikeDialog(android.support.v4.app.Fragment paramFragment)
  {
    this(new FragmentWrapper(paramFragment));
    AppMethodBeat.i(8133);
    AppMethodBeat.o(8133);
  }
  
  @Deprecated
  public LikeDialog(FragmentWrapper paramFragmentWrapper)
  {
    super(paramFragmentWrapper, DEFAULT_REQUEST_CODE);
  }
  
  @Deprecated
  public static boolean canShowNativeDialog()
  {
    return false;
  }
  
  @Deprecated
  public static boolean canShowWebFallback()
  {
    return false;
  }
  
  private static Bundle createParameters(LikeContent paramLikeContent)
  {
    AppMethodBeat.i(8138);
    Bundle localBundle = new Bundle();
    localBundle.putString("object_id", paramLikeContent.getObjectId());
    localBundle.putString("object_type", paramLikeContent.getObjectType());
    AppMethodBeat.o(8138);
    return localBundle;
  }
  
  private static DialogFeature getFeature()
  {
    return LikeDialogFeature.LIKE_DIALOG;
  }
  
  public AppCall createBaseAppCall()
  {
    AppMethodBeat.i(8135);
    AppCall localAppCall = new AppCall(getRequestCode());
    AppMethodBeat.o(8135);
    return localAppCall;
  }
  
  public List<FacebookDialogBase<LikeContent, Result>.ModeHandler> getOrderedModeHandlers()
  {
    AppMethodBeat.i(8136);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new NativeHandler(null));
    localArrayList.add(new WebFallbackHandler(null));
    AppMethodBeat.o(8136);
    return localArrayList;
  }
  
  public void registerCallbackImpl(CallbackManagerImpl paramCallbackManagerImpl, final FacebookCallback<Result> paramFacebookCallback)
  {
    AppMethodBeat.i(8137);
    if (paramFacebookCallback == null) {}
    for (paramFacebookCallback = null;; paramFacebookCallback = new ResultProcessor(paramFacebookCallback)
        {
          public void onSuccess(AppCall paramAnonymousAppCall, Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(8123);
            paramFacebookCallback.onSuccess(new LikeDialog.Result(paramAnonymousBundle));
            AppMethodBeat.o(8123);
          }
        })
    {
      paramFacebookCallback = new CallbackManagerImpl.Callback()
      {
        public boolean onActivityResult(int paramAnonymousInt, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(8124);
          boolean bool = ShareInternalUtility.handleActivityResult(LikeDialog.this.getRequestCode(), paramAnonymousInt, paramAnonymousIntent, paramFacebookCallback);
          AppMethodBeat.o(8124);
          return bool;
        }
      };
      paramCallbackManagerImpl.registerCallback(getRequestCode(), paramFacebookCallback);
      AppMethodBeat.o(8137);
      return;
    }
  }
  
  @Deprecated
  public void show(LikeContent paramLikeContent) {}
  
  class NativeHandler
    extends FacebookDialogBase<LikeContent, LikeDialog.Result>.ModeHandler
  {
    private NativeHandler()
    {
      super();
    }
    
    public boolean canShow(LikeContent paramLikeContent, boolean paramBoolean)
    {
      return false;
    }
    
    public AppCall createAppCall(final LikeContent paramLikeContent)
    {
      AppMethodBeat.i(8127);
      AppCall localAppCall = LikeDialog.this.createBaseAppCall();
      DialogPresenter.setupAppCallForNativeDialog(localAppCall, new DialogPresenter.ParameterProvider()
      {
        public Bundle getLegacyParameters()
        {
          AppMethodBeat.i(8126);
          Bundle localBundle = new Bundle();
          AppMethodBeat.o(8126);
          return localBundle;
        }
        
        public Bundle getParameters()
        {
          AppMethodBeat.i(8125);
          Bundle localBundle = LikeDialog.access$200(paramLikeContent);
          AppMethodBeat.o(8125);
          return localBundle;
        }
      }, LikeDialog.access$300());
      AppMethodBeat.o(8127);
      return localAppCall;
    }
  }
  
  @Deprecated
  public static final class Result
  {
    private final Bundle bundle;
    
    public Result(Bundle paramBundle)
    {
      this.bundle = paramBundle;
    }
    
    public final Bundle getData()
    {
      return this.bundle;
    }
  }
  
  class WebFallbackHandler
    extends FacebookDialogBase<LikeContent, LikeDialog.Result>.ModeHandler
  {
    private WebFallbackHandler()
    {
      super();
    }
    
    public boolean canShow(LikeContent paramLikeContent, boolean paramBoolean)
    {
      return false;
    }
    
    public AppCall createAppCall(LikeContent paramLikeContent)
    {
      AppMethodBeat.i(8130);
      AppCall localAppCall = LikeDialog.this.createBaseAppCall();
      DialogPresenter.setupAppCallForWebFallbackDialog(localAppCall, LikeDialog.access$200(paramLikeContent), LikeDialog.access$300());
      AppMethodBeat.o(8130);
      return localAppCall;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.share.internal.LikeDialog
 * JD-Core Version:    0.7.0.1
 */