package com.facebook.share.internal;

import android.app.Activity;
import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter.ParameterProvider;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class LikeDialog
  extends FacebookDialogBase<LikeContent, LikeDialog.Result>
{
  private static final int DEFAULT_REQUEST_CODE;
  private static final String TAG = "LikeDialog";
  
  static
  {
    AppMethodBeat.i(97118);
    DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.Like.toRequestCode();
    AppMethodBeat.o(97118);
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
    AppMethodBeat.i(97110);
    AppMethodBeat.o(97110);
  }
  
  @Deprecated
  public LikeDialog(android.support.v4.app.Fragment paramFragment)
  {
    this(new FragmentWrapper(paramFragment));
    AppMethodBeat.i(97109);
    AppMethodBeat.o(97109);
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
    AppMethodBeat.i(97114);
    Bundle localBundle = new Bundle();
    localBundle.putString("object_id", paramLikeContent.getObjectId());
    localBundle.putString("object_type", paramLikeContent.getObjectType());
    AppMethodBeat.o(97114);
    return localBundle;
  }
  
  private static DialogFeature getFeature()
  {
    return LikeDialogFeature.LIKE_DIALOG;
  }
  
  public AppCall createBaseAppCall()
  {
    AppMethodBeat.i(97111);
    AppCall localAppCall = new AppCall(getRequestCode());
    AppMethodBeat.o(97111);
    return localAppCall;
  }
  
  public List<FacebookDialogBase<LikeContent, LikeDialog.Result>.ModeHandler> getOrderedModeHandlers()
  {
    AppMethodBeat.i(97112);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new LikeDialog.NativeHandler(this, null));
    localArrayList.add(new LikeDialog.WebFallbackHandler(this, null));
    AppMethodBeat.o(97112);
    return localArrayList;
  }
  
  public void registerCallbackImpl(CallbackManagerImpl paramCallbackManagerImpl, FacebookCallback<LikeDialog.Result> paramFacebookCallback)
  {
    AppMethodBeat.i(97113);
    if (paramFacebookCallback == null) {}
    for (paramFacebookCallback = null;; paramFacebookCallback = new LikeDialog.1(this, paramFacebookCallback, paramFacebookCallback))
    {
      paramFacebookCallback = new LikeDialog.2(this, paramFacebookCallback);
      paramCallbackManagerImpl.registerCallback(getRequestCode(), paramFacebookCallback);
      AppMethodBeat.o(97113);
      return;
    }
  }
  
  @Deprecated
  public void show(LikeContent paramLikeContent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.share.internal.LikeDialog
 * JD-Core Version:    0.7.0.1
 */